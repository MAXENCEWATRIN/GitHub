package com.brasRobot.controlleur;
import com.brasRobot.ejb.javaBeansEjb;
import com.brasRobot.JavaBeans.Rasberry;
import com.brasRobot.JavaBeans.Preference;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
@Named
@RequestScoped
public class javaBeans {
    @EJB
    javaBeansEjb javaEjb; 
    Rasberry rasberry=new Rasberry();
    Preference preference = new Preference();//message camera
    private List<Preference> ListerPreference = new ArrayList<>();
    public void addMessageCamera() {
        System.out.println("Dans la camera");
        //ejb
        javaEjb.addMessageCameraEjb(rasberry.isCameraActif());
        //graphique
        String messageCamera = rasberry.isCameraActif() ? "la camera est allumer" : "la camera est etteint";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(messageCamera));
    }
    //message laser
    public void addMessageLaser() {
        System.out.println("Dans le laser");
        javaEjb.addMessageLaserEjb(rasberry.isLaser());
        String messageLaser = rasberry.isLaser()? "le laser est allumer" : "le laser est etteint";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(messageLaser));
    }
    //ajouter une preference
    public String ajouterPreference(){
        System.out.println("ajout de preference"); 
        javaEjb.ajouterPreferenceEjb(preference);
        System.out.println("ajouter preference réalisée avec succès");
        return"";
    }
    //enlever une preference
    public String supprimerPreference(){
        System.out.println("ajout de robot");  
        javaEjb.supprimerPreferenceEjb(preference);
        System.out.println("suppretion preference réalisée avec succès");
        return"";
    }
    //lancer la preference
    public void lancerPreference(){
        System.out.println("ajout de Go! Preference");  
     //javaEjb.supprimerPreferenceEjb(preference);
        System.out.println("lancement de preference réalisée avec succès"); 
    }  
    //modifier le laser
    public void ajouterLaser(){
        System.out.println("ajout de laser");  
        javaEjb.ajouterLaserEjb(rasberry);
        System.out.println("ajouter laser réalisée avec succès");
    }
    //get-set
    public Rasberry getRasberry() {
        return rasberry;
    }
    public void setRasberry(Rasberry rasberry) {
        this.rasberry = rasberry;
    }
    public Preference getPreference() {
        return preference;
    }
    public void setPreference(Preference preference) {
        this.preference = preference;
    }
    public List<Preference> getListerPreference() {
         this.ListerPreference = this.javaEjb.getListerPreference();
        return ListerPreference;
    }
    public void setListerPreference(List<Preference> ListerPreference) {
        this.ListerPreference = ListerPreference;
    } 
}
