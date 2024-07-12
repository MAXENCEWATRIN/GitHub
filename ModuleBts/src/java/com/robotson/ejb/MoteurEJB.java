package com.robotson.ejb;

import com.robotson.javabeans.Moteur;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@LocalBean
@Stateless
public class MoteurEJB {

    
    
    @PersistenceContext
    private EntityManager em;

    //liste de Moteur
    public List<Moteur> getListerMoteur() {
        Query query = em.createQuery("SELECT m FROM Moteur m");   
        return query.getResultList();
    }
    
    //ajouter et editer un Moteur
    public void editerMoteurEjb(Moteur m) {
        em.merge(m);      
    }

    
    //supprimer 
     public void supprimer(Moteur m) {
        em.remove(em.merge(m));     
    }
    
    //supprimer Rest
    public Moteur getMoteurById(int id) {
        Moteur m;
        m = em.find(Moteur.class, id);
        return m;
    }     
}