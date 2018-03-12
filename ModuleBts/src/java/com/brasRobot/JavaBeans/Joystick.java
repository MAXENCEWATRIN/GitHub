package com.brasRobot.JavaBeans;
import javax.ejb.Stateless;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
@Stateless
public class Joystick {//attendre l uml
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
int idJoystick;  
}