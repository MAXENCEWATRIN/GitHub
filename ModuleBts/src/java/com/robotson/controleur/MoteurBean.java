package com.robotson.controleur;

import com.robotson.javabeans.Moteur;
import com.robotson.ejb.MoteurEJB;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;



@Named
@RequestScoped
public class MoteurBean implements Serializable{  
    //creation de l'ejb Moteur
    @EJB
    private MoteurEJB moteurEjb;
    //classe Moteur     
    private Moteur moteur = new Moteur();   
    
    //constructeur
    public MoteurBean(){
    }

    
    //ajouter un Moteur
    public String editerMoteur() {
        //envoie de la methode a l'ejb
        moteurEjb.editerMoteurEjb(moteur);
        this.addMessage("moteur editée avec succès.");       
        System.out.println("moteur editée");
        return "admin?faces-redirect=true";
    }   
      
    
    
    
    //supprimer un moteur
    public String supprimer(Moteur moteur) {      
        moteurEjb.supprimer(moteur);
        this.addMessage("moteur supprimée avec succès.");
        System.out.println("moteur Supprimer");
        return "admin?faces-redirect=true";
    }
       
    
    
    
    public String editer(Moteur moteur) {
       this.moteur = moteur;     
       System.out.println("moteur editée ID");
       return "admin";
    } 

    
    //message preference 
      public void addMessage(String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, detail, null);
        FacesContext.getCurrentInstance().addMessage(null, message);  
    }

      
      //get set
    public MoteurEJB getMoteurEjb() {
        System.out.println("moteur idGet ");
        return moteurEjb;
    }
    public void setMoteurEjb(MoteurEJB moteurEjb) {
        this.moteurEjb = moteurEjb;
    }
    public Moteur getMoteur() {
        return moteur;
    }
    public void setMoteur(Moteur moteur) {
        this.moteur = moteur;
    }    
       public List<Moteur> getListeMoteur() {
        return moteurEjb.getListerMoteur();
    }  
}