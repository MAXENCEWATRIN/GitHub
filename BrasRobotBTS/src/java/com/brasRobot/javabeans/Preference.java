package com.brasRobot.javabeans;
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
int preferencePositionX;
int preferencePositionY;
int preferencePositionZ;
//get set
    public String getNomPreference() {
        return nomPreference;
    }
    public void setNomPreference(String nomPreference) {
        this.nomPreference = nomPreference;
    }
    public int getPreferencePositionX() {
        return preferencePositionX;
    }
    public void setPreferencePositionX(int preferencePositionX) {
        this.preferencePositionX = preferencePositionX;
    }
    public int getPreferencePositionY() {
        return preferencePositionY;
    }
    public void setPreferencePositionY(int preferencePositionY) {
        this.preferencePositionY = preferencePositionY;
    }
    public int getPreferencePositionZ() {
        return preferencePositionZ;
    }
    public void setPreferencePositionZ(int preferencePositionZ) {
        this.preferencePositionZ = preferencePositionZ;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }  
}
