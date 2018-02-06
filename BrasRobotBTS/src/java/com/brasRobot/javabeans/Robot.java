package com.brasRobot.javabeans;
import java.io.Serializable;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Stateless 
public class Robot implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
int numeroRobot;
int directionRobot;
//get set
    public int getNumeroRobot() {
        return numeroRobot;
    }
    public void setNumeroRobot(int numeroRobot) {
        this.numeroRobot = numeroRobot;
    }
    public int getDirectionRobot() {
        return directionRobot;
    }
    public void setDirectionRobot(int directionRobot) {
        this.directionRobot = directionRobot;
    }
}
