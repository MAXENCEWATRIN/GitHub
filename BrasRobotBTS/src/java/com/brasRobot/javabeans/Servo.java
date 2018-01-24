package com.brasRobot.javabeans;
import java.io.Serializable;
public class Servo implements Serializable {
    //attribut du servoMoteur
    private String libelleServo; 
    private int positionXServo;
    private int positionYServo;
    private int positionZServo;
    //
    public Servo()
    {}//Get-Set
    public String getLibelleServo()
    {return libelleServo;}
    
    public void setLibelleServo(String libelleServo)
    {this.libelleServo = libelleServo;}
    
    public int getPositionXServo() 
    {return positionXServo;}
    
    public void setPositionXServo(int positionXServo) 
    {this.positionXServo = positionXServo;}
    
    public int getPositionYServo() 
    {return positionYServo;}
    
    public void setPositionYServo(int positionYServo) 
    {this.positionYServo = positionYServo;}
    
    public int getPositionZServo() 
    {return positionZServo;}
    
    public void setPositionZServo(int positionZServo)
    {this.positionZServo = positionZServo;} 
    //
}