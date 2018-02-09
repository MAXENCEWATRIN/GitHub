package com.brasRobot.JavaBeans;
import java.io.Serializable;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
@Entity
@Stateless
public class Rasberry implements Serializable{ 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int IdRasberry;
    int son;
    boolean laser;
    boolean cameraActif;
    public Rasberry() {
    }
     //get-set
    public int getSon() {
        return son;
    }
    public void setSon(int son) {
        this.son = son;
        System.out.println("le son est de: "+son);
    }
    public boolean isLaser() {
        return laser;
    }
    public void setLaser(boolean laser) {
        this.laser = laser;
    }
    public boolean isCameraActif() {
        return cameraActif;
    }
    public void setCameraActif(boolean cameraActif) {
        this.cameraActif = cameraActif;
    }
    public int getIdRasberry() {
        return IdRasberry;
    }
    public void setIdRasberry(int IdRasberry) {
        this.IdRasberry = IdRasberry;
    }  
}