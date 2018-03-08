package com.brasRobot.controlleur;
import com.brasRobot.JavaBeans.Moteur;
import com.brasRobot.JavaBeans.Musicien;
import com.brasRobot.ejb.javaBeansEjb;
import com.brasRobot.JavaBeans.Preference;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
@Named
@RequestScoped
public class javaBeans {
    @EJB
    javaBeansEjb javaEjb; 
    Musicien musicien =new Musicien();
    Preference preference = new Preference();
    Moteur moteur = new Moteur();
    public void addMessageCamera() {
        System.out.println("Dans la camera");
        //ejb
        javaEjb.addMessageCameraEjb(musicien.isCamera());
        //graphique
        String messageCamera = musicien.isCamera()? "la camera est allumer" : "la camera est etteint";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(messageCamera));
    }
    //message laser
    public void addMessageLaser() {
        System.out.println("Dans le laser");
        javaEjb.addMessageLaserEjb(musicien.isLaser());
        String messageLaser = musicien.isLaser()? "le laser est allumer" : "le laser est etteint";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(messageLaser));
    }
    //ajouter une preference
    public void ajouterPreference(){
        System.out.println("ajout de preference"); 
        javaEjb.ajouterPreferenceEjb(preference);
        System.out.println("ajouter preference réalisée avec succès");
    }
    //modifier le laser
    public void ajouterMusicien(){
        System.out.println("ajout de laser");  
        javaEjb.ajouterMusicienEjb(musicien);
        System.out.println("ajouter laser réalisée avec succès");
    }  
    public void ajouterMoteur(){
        System.out.println("ajout du moteur");  
        javaEjb.ajouterMoteurEjb(moteur);
        System.out.println("ajouter moteur réalisée avec succès");
    }
    
    
    
    
    //get-set
    public Musicien getMusicien() {
        return musicien;
    }
    public void setMusicien(Musicien musicien) {
        this.musicien = musicien;
    }
    public Preference getPreference() {
        return preference;
    }
    public void setPreference(Preference preference) {
        this.preference = preference;
    }
    public Moteur getMoteur() {
        return moteur;
    }
    public void setMoteur(Moteur moteur) {
        this.moteur = moteur;
    }    
}