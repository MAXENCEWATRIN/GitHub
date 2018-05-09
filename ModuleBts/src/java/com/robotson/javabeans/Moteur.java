package com.robotson.javabeans;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Moteur implements Serializable {
    
    //creation des methodes
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idMoteur; 
    private String libelle;
    private int position;
    
    @ManyToOne
    Preference preference = new Preference();
    // POJO
    public Moteur() {
    }
      
    //get set
    public int getIdMoteur() {
        return idMoteur;
    }
    public void setIdMoteur(int idMoteur) {
        this.idMoteur = idMoteur;
    }
    public String getLibelle() {
        return libelle;
    }
    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }   
    public int getPosition() {
        return position;
    }
    public void setPosition(int position) {
        this.position = position;
    }
    public Preference getPreference() {
        return preference;
    }
    public void setPreference(Preference preference) {
        this.preference = preference;
    }
}