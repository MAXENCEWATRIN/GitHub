package com.robotson.ejb;

import com.robotson.javabeans.Musicien;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class MusicienEJB {

    
    
    @PersistenceContext
    private EntityManager em;

    public MusicienEJB() {
    }


    
    //ajouter ET editer un musicien
    public void editerMusicienEjb(Musicien m) {
        em.merge(m);
    }
   
      //supprimer 
     public void supprimer(Musicien m) {
        em.remove(em.merge(m));
    }
    
    public List<Musicien> lister() {
        Query query = em.createQuery("SELECT listeMusiciens FROM Musicien listeMusiciens ORDER BY listeMusiciens.nom ASC");
        return query.getResultList();
    } 
     
    //supprimer Rest
    public Musicien getMusicienById(int idMusicien) {
        System.out.println(idMusicien);
        return em.find(Musicien.class, idMusicien);
    }
   

}