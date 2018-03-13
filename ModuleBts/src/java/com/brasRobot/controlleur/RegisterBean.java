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
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Maxence
 */
@Named
@RequestScoped
public class RegisterBean {
    
    public void handleFileUpload(FileUploadEvent event) {
        FacesMessage message = new FacesMessage("fichier", event.getFile().getFileName() + " enregistré.");
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
    
}
