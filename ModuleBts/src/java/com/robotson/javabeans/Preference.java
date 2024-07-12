package com.robotson.javabeans;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;



@Entity
@XmlRootElement
public class Preference implements Serializable {  
    
    //creation des methodes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPreference;
    private String libelle;

    @ManyToOne
    Musicien musicien = new Musicien();  


    //constructeur
    public Preference() {
    }
    //getters/setters

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    

    public int getIdPreference() {
        return idPreference;
    }

    public void setIdPreference(int idPreference) {
        this.idPreference = idPreference;
    }

    public Musicien getMusicien() {
        return musicien;
    }

    public void setMusicien(Musicien musicien) {
        this.musicien = musicien;
    }
}