package com.robotson.ejb;

import com.robotson.javabeans.Musicien;
import com.robotson.javabeans.Preference;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;


@Stateless
public class PreferenceEJB {
    
    @PersistenceContext
    private EntityManager em;

    public PreferenceEJB() {
    }
    
    //ajouter et editer une Preference
    public void editerPreferenceEjb(Preference preference) {
        // enlever le cache de cette donnée pour etre a jour
        // forcer a recharger le musicien et donc ses préférences
        em.getEntityManagerFactory().getCache().evict(Musicien.class, preference.getMusicien().getIdMusicien());
       
        em.merge(preference);    
    }
    
    public void supprimer(Preference preference) {
        System.out.println("CACHE : "+preference.getMusicien().getIdMusicien());
         // enlever le cache de cette donnée pour etre a jour
        // forcer a recharger le musicien et donc ses préférences
        em.getEntityManagerFactory().getCache().evict(Musicien.class, preference.getMusicien().getIdMusicien());
       
        em.remove(em.merge(preference));
        
    }
    //liste de preference
    public List<Preference> getListerPreference() {
        Query query = em.createQuery("SELECT p FROM Preference p");   
        return query.getResultList();
    }
    
  

    public List<Preference> getPreferenceByIdMusicien(int idMusicien) {
        // forcer a recharger le musicien et donc ses préférences
        em.getEntityManagerFactory().getCache().evict(Musicien.class,idMusicien);
        Query query = em.createQuery("SELECT listePreferences FROM Preference listePreferences WHERE listePreferences.musicien.idMusicien=:idMusicien ORDER BY listePreferences.libelle ASC");
        query.setParameter("idMusicien", idMusicien);
        query.getFlushMode();
        em.flush();
        return query.getResultList();
    }
    
    
   public Preference getPreferenceById(int idPreference) {
        return em.find(Preference.class, idPreference);
    }
    
  
}