package com.brasRobot.controlleur;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
@Named
@RequestScoped
public class Liste implements Serializable {
    //acceuil
     public String accueil() {
     System.out.println("Dans l'accueil");        
        return "accueil";
    }
    //laser
    public String laser() {
    System.out.println("Dans le laser");
      return "laser";
    }   
    //preference
    public String preference() {
    System.out.println("Dans la preference");
      return "preference";
    }  
     //preferenceEditer
    public String preferenceEditer() {
    System.out.println("Dans la preferenceEditer");
      return "preferenceEditer";
    }
    
}