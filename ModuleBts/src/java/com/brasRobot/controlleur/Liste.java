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
    //laser(laser,camera,son)
    public String laser() {
    System.out.println("Dans le laser");
      return "laser";
    }   
    //preference(list:nom,image)
    public String preference() {
    System.out.println("Dans la preference");
      return "preference";
    }  
     //editer la preference(nom,image)
    public String preferenceEditer() {
    System.out.println("Dans la preferenceEditer");
      return "preferenceEditer";
    }  
}