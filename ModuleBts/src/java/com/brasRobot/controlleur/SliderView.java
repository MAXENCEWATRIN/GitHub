/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.brasRobot.controlleur;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
 
import org.primefaces.event.SlideEndEvent;

/**
 *
 * @author Maxence
 */
@Named
@RequestScoped
public class SliderView {
    
    
    private int number1;
    
 
    public int getNumber1() {
        return number1;
    }
 
    public void setNumber1(int number1) {
        this.number1 = number1;
    }
 
  
    public void onInputChanged(ValueChangeEvent event) {
        FacesMessage message = new FacesMessage("Input Changed", "Value: " + event.getNewValue());
        FacesContext.getCurrentInstance().addMessage(null, message);
    } 
     
    public void onSlideEnd(SlideEndEvent event) {
        FacesMessage message = new FacesMessage("Slide Ended", "Value: " + event.getValue());
        FacesContext.getCurrentInstance().addMessage(null, message);
    } 
    
    
}
