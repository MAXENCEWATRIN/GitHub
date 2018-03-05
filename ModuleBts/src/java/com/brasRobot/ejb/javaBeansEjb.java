package com.brasRobot.ejb;
import com.brasRobot.JavaBeans.Preference;
import com.brasRobot.JavaBeans.Rasberry;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
@LocalBean
@Stateless
public class javaBeansEjb {
    @PersistenceContext
    EntityManager em;
    public  List<Preference> getListerPreference(){
        System.out.println("liste de preference");
        Query query = em.createQuery("Select p FROM PREFERENCE");
        return query.getResultList();
    }
    //ejb camera console
    public boolean addMessageCameraEjb(boolean messageCamera) {
        System.out.println("Dans le ejb camera");
        if(messageCamera==true){
          System.out.println("camera activé");
        }
        if(messageCamera==false){
          System.out.println("camera etteinte");
        }
        return messageCamera;
    } 
    //ejb laser console
    public boolean addMessageLaserEjb(boolean messageLaser) {
        System.out.println("Dans le ejb laser");
        if(messageLaser==true){
            System.out.println("laser activé");
        }
        if(messageLaser==false){
            System.out.println("laser etteint");
        }
        return messageLaser;
        }  
    //ajout de Preference
    public void ajouterPreferenceEjb(Preference p) {
        System.out.println("Dans le ajouter preference ejb ");
        em.merge(p);
    }
    //supprimer Preference
    public String supprimerPreferenceEjb(Preference p) {//
        System.out.println("Dans le suprimer Preference ejb ");
        //em.merge(p);      
        return "";
    }
    //ajout de laser
    public void ajouterLaserEjb(Rasberry r) {//
        System.out.println("Dans le ajouter rasberry ejb ");
        em.merge(r);
    }
}
