package com.brasRobot.controlleur;

import com.brasRobot.ejb.robotEjb;
import com.brasRobot.javabeans.Preference;
import com.brasRobot.javabeans.Rasberry;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
@Named
@RequestScoped
public class viewAjax {
    @EJB
    robotEjb robotejb; 
    Rasberry rasberry=new Rasberry();
    Preference preference = new Preference();
    //message camera
    public void addMessageCamera() {
        System.out.println("Dans la camera");
        robotejb.addMessageCameraEjb(rasberry.isCameraActif());
        String messageCamera = rasberry.isCameraActif() ? "la camera est allumer" : "la camera est etteint";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(messageCamera));
    }
    //message laser
    public void addMessageLaser() {
        System.out.println("Dans le laser");
        robotejb.addMessageLaserEjb(rasberry.isLaser());
        String messageLaser = rasberry.isLaser()? "le laser est allumer" : "le laser est etteint";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(messageLaser));
    }
    //dans le son
    public String number(){
    System.out.println("Dans le number");
    robotejb.getNumberEjb(rasberry.getSon());
    return"le son est de :"+rasberry.getSon()+"%";
    }
    public String ajouterPreference(){
    System.out.println("ajout de preference");  
    robotejb.ajouterPreferenceEjb(preference);
    FacesMessage message = new FacesMessage("ajouter preference réalisée avec succès");
        FacesContext.getCurrentInstance().addMessage(null, message);
        return "acceuil";
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
}
