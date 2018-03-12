package com.brasRobot.JavaBeans;
import java.io.Serializable;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
@Stateless
public class Musicien implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int IdMusicien;
    String nom;
    int son;
    boolean laser;
    boolean camera;
    String image;
    
//get set
    public int getIdMusicien() {
        return IdMusicien;
    }
    public void setIdMusicien(int IdMusicien) {
        this.IdMusicien = IdMusicien;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public int getSon() {
        return son;
    }
    public void setSon(int son) {
        this.son = son;
    }
    public boolean isLaser() {
        return laser;
    }
    public void setLaser(boolean laser) {
        this.laser = laser;
    }
    public boolean isCamera() {
        return camera;
    }
    public void setCamera(boolean camera) {
        this.camera = camera;
    } 

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


}