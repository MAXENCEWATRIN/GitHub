package com.brasRobot.JavaBeans;
import java.io.Serializable;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
@Stateless
public class Preference implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int IdPreference;
    String nomPreference;
    String image;
//get set
    public String getNomPreference() {
        return nomPreference;
    }
    public void setNomPreference(String nomPreference) {
        this.nomPreference = nomPreference;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }  
    public int getIdPreference() {
        return IdPreference;
    }
    public void setIdPreference(int IdPreference) {
        this.IdPreference = IdPreference;
    }
}