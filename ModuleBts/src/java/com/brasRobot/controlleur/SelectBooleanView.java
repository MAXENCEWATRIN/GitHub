/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brasRobot.controlleur;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Maxence
 */
@Named
@RequestScoped
public class SelectBooleanView {
    
    
    
    private boolean value2;
 
    public boolean isValue2() {
        return value2;
    }
 
    public void setValue2(boolean value2) {
        this.value2 = value2;
    }
     
    public void addMessage() {
        String summary = value2 ? "Laser actif" : "Laser inactif";
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(summary));
 
    
}
}
