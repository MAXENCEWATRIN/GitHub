package com.brasRobot.ejb;

//import com.brasRobot.JavaBeans.Moteur;
import com.brasRobot.JavaBeans.Musicien;
import com.brasRobot.JavaBeans.Preference;
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

    public List<Preference> getListerPreference() {
        System.out.println("liste de preference");
        Query query = em.createQuery("Select p FROM PREFERENCE");
        return query.getResultList();
    }

    //ejb camera console
    public boolean addMessageCameraEjb(boolean messageCamera) {
        System.out.println("Dans le ejb camera");
        if (messageCamera == true) {
            System.out.println("camera activé");
        }
        if (messageCamera == false) {
            System.out.println("camera etteinte");
        }
        return messageCamera;
    }

    //ejb laser console
    public boolean addMessageLaserEjb(boolean messageLaser) {
        System.out.println("Dans le ejb laser");
        if (messageLaser == true) {
            System.out.println("laser activé");
        }
        if (messageLaser == false) {
            System.out.println("laser etteint");
        }
        return messageLaser;
    }

    //ajout de Preference
    public void ajouterPreferenceEjb(Preference p) {
        System.out.println("Dans le ajouter preference ejb ");
        em.merge(p);
    }

    //ajout de laser
    public void ajouterMusicienEjb(Musicien m) {
        System.out.println("Dans le ajouter musicien ejb ");
        em.merge(m);
    }

    //ajout de moteur
//    public void ajouterMoteurEjb(Moteur m) {
//        System.out.println("Dans le ajouter moteur ejb ");
//        em.merge(m);
//    }
}
