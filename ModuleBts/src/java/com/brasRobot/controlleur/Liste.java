package com.brasRobot.controlleur;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
@Named
@RequestScoped
public class Liste implements Serializable {
    //ACCEUIL
     public String accueil() {
     System.out.println("Dans l'accueil");        
        return "accueil";
    }
     //musicien
    public String musicien() {
     System.out.println("Dans musicien");        
        return "musicien";
    }
    //preference
    public String preference() {
     System.out.println("Dans la preference");        
        return "preference";
    }
      //preferenceediter
    public String preferenceEditer() {
     System.out.println("Dans la preference editer");        
        return "preferenceEditer";
    }   
    //preferenceediter
    public String moteur() {
     System.out.println("Dans le moteur");        
        return "moteur";
    }
}