/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.robotson.controleur;

import com.robotson.ejb.MusicienEJB;
import com.robotson.ejb.PreferenceEJB;
import com.robotson.javabeans.Musicien;
import com.robotson.javabeans.Preference;
import java.io.File;
import java.nio.file.Files;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.SlideEndEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author maxen
 */
@Named
@RequestScoped
public class IhmBean {

    // injection de l'EJB
    @EJB
    private MusicienEJB musicienEJB;

    @EJB
    private PreferenceEJB preferenceEJB;

    // copie du fichier image
    private UploadedFile file;

    //backing bean
    private Musicien musicien = new Musicien();

    //liste des musiciens
    private List<Musicien> listeMusiciens;

    //backing bean
    private Preference preference = new Preference();

    //liste des préférences du musicien
    private List<Preference> listePreferencesMusicien;

    private int sliderHorizontal;
    private int sliderVertical;

    //Constructeur
    public IhmBean() {
    }

    /**
     * ***********************************************************************
     */
    /**
     * *********************Controleur front ajax : Musicien******************
     */
    /**
     * ***********************************************************************
     */
    // vider le formulaire ajax
    public void vider() {
        // vider le musicien pour le formulaire de la vue
        this.musicien = new Musicien();
    }

    // create or update
    public void editer() {
        System.out.println("clic sur editer " + this.musicien.getImage());

        //on est en creation et on n'a pas voulu d'image, mettre celle par défaut
        if (this.musicien.getImage().equalsIgnoreCase("")) {
            ExternalContext external = FacesContext.getCurrentInstance().getExternalContext();
            this.musicien.setImage(external.getInitParameter("PATH_IMG_ROBOTSOUND"));
        }

        // editer le musicien (ajout ou modification en fonction de l'id)
        musicienEJB.editerMusicienEjb(this.musicien);
        // vider le musicien pour le formulaire de la vue
        this.musicien = new Musicien();
        //ajouter le message JSF
        FacesMessage message = new FacesMessage("Edition du musicien réalisée avec succès");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    // supprimer
    public void supprimer() {
        // supprimer l'image sur le disque dur
        this.supprimerImage(this.musicien.getImage());
        // supprimer le musicien (ajout ou modification en fonction de l'id)
        musicienEJB.supprimer(this.musicien);
        // vider le musicien pour le formulaire de la vue
        this.musicien = new Musicien();
        //ajouter le message JSF
        FacesMessage message = new FacesMessage("Suppression du musicien réalisée avec succès");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    // choix d'une image dans le carroussel
    public void carroussel() {
        System.out.println("DANS LE CARROUSSEL");
        // recuperer le musicien correspondant a la pochette
        try {
            int idMusicien = Integer.parseInt(FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("idMusicien"));
            System.out.println("Musicien cliqué : " + idMusicien);
            //charger le musicien de la BD
            this.musicien = musicienEJB.getMusicienById(idMusicien);
        } catch (Exception e) {
        }
    }

    public void upload(FileUploadEvent event) {

        //System.out.println("DEDANS "+event.getFile().getFileName());
        this.file = event.getFile();

        // fichier uploade
        if (file != null && !file.getFileName().equalsIgnoreCase("")) {
            // verifier si c'est une modification de l'image
//            int idRider=this.rider.getIdRider();
//            System.out.println("VIRE : "+idRider+" file "+file.getFileName());
//            if(idRider>0){
//                Rider r=this.riderEJB.find(idRider);
//                this.removeImg(r.getImgRider());
//            }

            final ExternalContext external = FacesContext.getCurrentInstance().getExternalContext();
            final String PATH_IMG_MUSICIEN = external.getInitParameter("PATH_IMG_MUSICIEN");

            try {
                // chemin du fichier de destination
                String imgMusicienName = this.generatedRandomNameFile();
                String destinationPath = PATH_IMG_MUSICIEN + java.io.File.separator + imgMusicienName;
                System.out.println("Copier le fichier dans le répetoire : " + destinationPath);
                // creer le fichier sur le serveur
                File destinationFile = new File(destinationPath);
                // copier le fichier source vers la destination
                Files.copy(file.getInputstream(), destinationFile.toPath());
                // affecter le chemin au rider
                //this.rider.setImgRider(imgRiderName);
                this.musicien.setImage(imgMusicienName);

                // message de succes
                FacesMessage message = new FacesMessage("Succesful", file.getFileName() + " is uploaded.");
                FacesContext.getCurrentInstance().addMessage(null, message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    // generer un nom au hasard
    public String generatedRandomNameFile() {
        int i = (int) (Math.random() * 100000000);
        return String.valueOf(i) + ".png";
    }

    // supprimer l'image du musicien si elle existe et si c'est pas celle par defaut
    public void supprimerImage(String imageMusicien) {

        ExternalContext external = FacesContext.getCurrentInstance().getExternalContext();

        // image par defaut
        String imageDefaut = external.getInitParameter("PATH_IMG_ROBOTSOUND");

        if (imageMusicien != null && !imageMusicien.equalsIgnoreCase("") && !imageMusicien.equals(imageDefaut)) {

            String PATH_IMG_MUSICIEN = external.getInitParameter("PATH_IMG_MUSICIEN");

            // url de stockage de la photo
            String destinationPath = PATH_IMG_MUSICIEN + java.io.File.separator + imageMusicien;
            System.out.println("Supprimer l'image : " + destinationPath);
            File oldFile = new File(destinationPath);
            if (oldFile.exists()) {
                oldFile.delete();
            }
        }
    }

    /**
     * ***********************************************************************
     */
    /**
     * *********************Controleur front ajax : Preference****************
     */
    /**
     * ***********************************************************************
     */
    // creer ou changer
    public void editerPreference() {
        System.out.println("clic sur editer preference " + this.preference.getLibelle());
        System.out.println("clic sur editer preference id musicien :" + this.musicien.getIdMusicien());

        // trouver le musicien concerné par la préférence
        if (this.musicien.getIdMusicien() > 0) {

            System.out.println("dans if");

            Musicien m = musicienEJB.getMusicienById(this.musicien.getIdMusicien());
            //associer sa préférence au musicien
            this.preference.setMusicien(m);
            //editer la préférence du musicien (ajout ou modification en fonction de l'id)
            preferenceEJB.editerPreferenceEjb(this.preference);
            System.out.println("ajout en cours");
            // vider la préférence pour le formulaire de la vue
            this.preference = new Preference();
            //ajouter le message JSF
            FacesMessage message = new FacesMessage("Edition de la préférence réalisée avec succès");
            FacesContext.getCurrentInstance().addMessage(null, message);
        }
    }

    
    public void supprimerPref(Preference p){
        
        
        preferenceEJB.supprimer(preference);
        
    }
    
    // supprimer
    public void supprimerPreference(Preference preference) {
       
        System.out.println("SUPPRIMER LA PREFERENCE : " + preference);
        System.out.println("MUSICIEN PREFERENCE : " + preference.getMusicien().getIdMusicien());
        System.out.println("MUSICIEN PREFERENCE : " + this.musicien.getIdMusicien());
        //this.musicien.setIdMusicien(preference.getMusicien().getIdMusicien());
        // supprimer la préférence
        
        preferenceEJB.supprimer(preference);
                   
        //ajouter le message JSF
        FacesMessage message = new FacesMessage("Suppression de la préférence réalisée avec succès");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
    public List<Preference> getListePreferencesMusicien() {
        //System.out.println("clic sur getPreferencesMusicien" + this.musicien.getIdMusicien());
        return this.preferenceEJB.getPreferenceByIdMusicien(this.musicien.getIdMusicien());
    }

    //Test slide ajax horizontal
    public void onSlideEnd(SlideEndEvent event) {
        FacesMessage message = new FacesMessage("Slide Horizontal", "Value: " + event.getValue());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    //Test slide ajax vertical
    public void onSlideEndVert(SlideEndEvent event) {
        FacesMessage message = new FacesMessage("Slide vertical", "Value: " + event.getValue());
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    //GETTER/SETTER
    public Musicien getMusicien() {
        return musicien;
    }

    public void setMusicien(Musicien musicien) {
        this.musicien = musicien;
    }

    public List<Musicien> getListeMusiciens() {
        return musicienEJB.lister();
    }

    public void setListeMusiciens(List<Musicien> listeMusiciens) {
        this.listeMusiciens = listeMusiciens;
    }

    public Preference getPreference() {
        return preference;
    }

    public void setPreference(Preference preference) {
        this.preference = preference;
    }

    //AJAX SLIDE GETSET
    public int getSliderHorizontal() {
        return sliderHorizontal;
    }

    public void setSliderHorizontal(int sliderHorizontal) {
        this.sliderHorizontal = sliderHorizontal;
    }

    public int getSliderVertical() {
        return sliderVertical;
    }

    public void setSliderVertical(int sliderVertical) {
        this.sliderVertical = sliderVertical;
    }

}
