package com.robotson.controleur;
import com.robotson.ejb.MusicienEJB;
import com.robotson.javabeans.Musicien;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

@Named
@RequestScoped
public class MusicienBean implements Serializable{  
    
    //creation de l'ejb preference
    @EJB
    private MusicienEJB musicienEjb;
    //classe preference     
    private Musicien musicien = new Musicien();   

    
    //constructeur
    public MusicienBean(){
    }

    
    
    
    
    //ajouter un musicien
    public String editerMusicien() {
        //envoie de la methode a l'ejb
        musicienEjb.editerMusicienEjb(musicien);
        this.addMessage("Musicien editée avec succès.");        
        //System.out.println("Musicien editée");
        //return "listerMusicien";
        return "admin?faces-redirect=true";
    }   
      
    
    
    
    //supprimer une preference
    public String supprimer(Musicien musicien) {
        musicienEjb.supprimer(musicien);//ne fonctionne pas car n'arrive a trouver l'iD
        this.addMessage("musicien supprimée avec succès.");        
        //System.out.println("musicien supprimée"); 
        //return "listerMusicien?faces-redirect=true";//?faces-redirect=true" permet de rapeller la page
        return "admin?faces-redirect=true";
    }
       
    
    
    
    
    //retrouver un musicien ID 
    public String editer(Musicien musicien) {
       this.musicien = musicien;//ne fonctionne pas car n'arrive a trouver l'iD
       //System.out.println("musicien editée iD");
       //return "editerMusicien";
       return "admin";
    } 

    
    
    
    
    
    
    
    
   
    //message preference 
      public void addMessage(String detail) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, detail,null);
        FacesContext.getCurrentInstance().addMessage(null, message);  
    }
    
      
      
      
      
  
    
      
    //get set  
    public Musicien getMusicien() {    
        //System.out.println("musicien idGet");//l'appel 4 fois car 4 champs
        return musicien;
    }
    public void setMusicien(Musicien musicien) {
        this.musicien = musicien;
    }
    public MusicienEJB getMusicienEjb() {
        return musicienEjb;
    }

    public void setMusicienEjb(MusicienEJB musicienEjb) {
        this.musicienEjb = musicienEjb;
    }

    public List<Musicien> getListeMusicien() {
        return musicienEjb.lister();
    }  
}