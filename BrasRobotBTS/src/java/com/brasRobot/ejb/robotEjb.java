package com.brasRobot.ejb;

import com.brasRobot.javabeans.Preference;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@LocalBean
@Stateless
public class robotEjb {
    @PersistenceContext
    EntityManager em;
//ejb camera
 public boolean addMessageCameraEjb(boolean messageCamera) {
       System.out.println("Dans le ejb camera");
       if(messageCamera==true){
        System.out.println("camera activé");
        em.update(c);
       }
       if(messageCamera==false){
         System.out.println("camera etteinte");
         em.update(c);
       }
       //em.merge();
       return messageCamera;
    } 
//ejb laser
 public boolean addMessageLaserEjb(boolean messageLaser) {
        System.out.println("Dans le ejb laser");
        if(messageLaser==true){
           System.out.println("laser activé");
           em.update(c);
        }
        if(messageLaser==false){
           System.out.println("laser etteint");
           em.update(p);
        }
       return messageLaser;
    }  
//ejb son
  public int getNumberEjb(int son) {
        System.out.println("Dans le ejb son");
       //em.merge(son);
      return son;
    }  
  //ajout de preference
   public String ajouterPreferenceEjb(Preference p) {
        System.out.println("Dans le ajouter preference ejb ");
       em.merge(p);
       return "acceuil";
    }
}
