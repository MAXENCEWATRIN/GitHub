package com.robotson.controleur;
import com.robotson.javabeans.Preference;
import com.robotson.ejb.PreferenceEJB;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@RequestScoped
public class PreferenceBean implements Serializable{  
    
    //creation de l'ejb preference
    @EJB
    private PreferenceEJB preferenceEjb;
    //classe preference     
    private Preference preference = new Preference();   

    
    //constructeur
    public PreferenceBean(){
    }

  
    
    //ajouter une preference
    public String editerPreference() {
        //envoie de la methode a l'ejb
        preferenceEjb.editerPreferenceEjb(preference);
        this.addMessage("Préférence editée avec succès.");       
        //System.out.println("Preference editée");
        //return "listerPreference";
        return "admin?faces-redirect=true";
    }   
      
    
    
    
    //supprimer une preference
    public String supprimer(Preference preference) {      
        preferenceEjb.supprimer(preference);
        this.addMessage("Préférence supprimée avec succès.");
        //System.out.println("Preference Supprimer");
     // return "listerPreference?faces-redirect=true";//?faces-redirect=true permet de rapeller la page
        return "admin?faces-redirect=true";
    }
       
    
    
    
    //retrouver une preference pour l'editer  (garde le libelle en Bdd *le supprimer)
    public String editer(Preference preference) {
       this.preference = preference;     
       //System.out.println("Preference editée ID");
      // return "editerPreference";
       return "admin";
    } 

    
    //message preference 
      public void addMessage(String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, detail, null);
        FacesContext.getCurrentInstance().addMessage(null, message);  
    }
    
      
      
      
      
  
    
      
    //get set  
    public Preference getPreference() {    
        //System.out.println("Preference idGet ");
        return preference;
    }
    public void setPreference(Preference preference) {
        this.preference = preference;
    }
    public PreferenceEJB getPreferenceEjb() {
        return preferenceEjb;
    }

    public void setPreferenceEjb(PreferenceEJB preferenceEjb) {
        this.preferenceEjb = preferenceEjb;
    }

    public List<Preference> getListePreferences() {
        return preferenceEjb.getListerPreference();
    }  
}