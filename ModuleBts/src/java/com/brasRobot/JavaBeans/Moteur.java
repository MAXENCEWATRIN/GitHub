package com.brasRobot.JavaBeans;
import java.io.Serializable;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
@Stateless
public class Moteur implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int idMoteur;
    int  position;
//get set
    public int getIdMoteur() {
        return idMoteur;
    }
    public void setIdMoteur(int idMoteur) {
        this.idMoteur = idMoteur;
    }
    public int getPosition() {
        return position;
    }
    public void setPosition(int position) {
        this.position = position;
    }  
}