package com.robotson.javabeans;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;




@Entity
@XmlRootElement
public class Musicien implements Serializable {
    
    //creation des methodes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMusicien; 
    private String nom;
    private boolean laser;
    private String image="";
    
    
    @OneToMany(cascade = CascadeType.REMOVE,mappedBy = "musicien",fetch = FetchType.EAGER)
    private List<Preference> listePreferences;
    
    
    // POJO
    public Musicien() {
    }
    //getters / setters
    public int getIdMusicien() {      
        return idMusicien;
    }
    public void setIdMusicien(int idMusicien) {
        this.idMusicien = idMusicien;
    }
    @XmlTransient
    public List<Preference> getListePreferences() {
        return listePreferences;
    }

    public void setListePreferences(List<Preference> listePreferences) {
        this.listePreferences = listePreferences;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public boolean isLaser() {
        return laser;
    }
    public void setLaser(boolean laser) {
        this.laser = laser;
    }   
}