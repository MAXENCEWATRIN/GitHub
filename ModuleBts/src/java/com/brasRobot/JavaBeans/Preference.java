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
    
//get set
    public String getNomPreference() {
        return nomPreference;
    }
    public void setNomPreference(String nomPreference) {
        this.nomPreference = nomPreference;
    }
    
    public int getIdPreference() {
        return IdPreference;
    }
    public void setIdPreference(int IdPreference) {
        this.IdPreference = IdPreference;
    }
}