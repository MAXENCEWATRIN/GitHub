package com.brasRobot.javabeans;
import java.io.Serializable;
public class Preference implements Serializable {
    //classe de mes preference
    private String libellePref; 
    private int positionXPref;
    private int positionYPref;
    private int positionZPref;
    //
    public Preference() {
    }
    
    //Get-Set
    public String getLibellePref() {
        return libellePref;
    }
    public void setLibellePref(String libellePref) {
        this.libellePref = libellePref;
    }
    public int getPositionXPref() {
        return positionXPref;
    }
    public void setPositionXPref(int positionXPref) {
        this.positionXPref = positionXPref;
    }
    public int getPositionYPref() {
        return positionYPref;
    }
    public void setPositionYPref(int positionYPref) {
        this.positionYPref = positionYPref;
    }
    public int getPositionZPref() {
        return positionZPref;
    }
    public void setPositionZPref(int positionZPref) {
        this.positionZPref = positionZPref;
    }
    //
}