package com.brasRobot.javabeans;
import java.io.Serializable;
public class Media implements Serializable {
    //attribut du media
    private boolean laser; 
    private int volume;
    Servo servo = new Servo();
    Preference pref = new Preference();  
    //
    public Media() 
    {}//Get-Set
    public boolean isLaser() 
    {return laser;}
    
    public void setLaser(boolean laser)
    {this.laser = laser;}
    
    public int getVolume() 
    {return volume;}
    
    public void setVolume(int volume) 
    {this.volume = volume;}
    
    public Servo getServo() 
    {return servo;}
    
    public void setServo(Servo servo) 
    {this.servo = servo;}
    
    public Preference getPref() 
    {return pref;}
    
    public void setPref(Preference pref)
    {this.pref = pref;}  
    //
}