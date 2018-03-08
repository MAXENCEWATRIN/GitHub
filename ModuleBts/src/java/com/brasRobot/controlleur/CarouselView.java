package com.brasRobot.controlleur;

import com.brasRobot.JavaBeans.Musicien;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Maxence
 */
@Named
@RequestScoped
public class CarouselView implements Serializable {
     
    private List<Musicien> musiciens;
     
    private Musicien musicienSelectionne;

    public CarouselView() {
    }

    
    public CarouselView(List<Musicien> musiciens, Musicien musicienSelectionne) {
        this.musiciens = musiciens;
        this.musicienSelectionne = musicienSelectionne;
    }
     
    
    public List<Musicien> getMusiciens() {
        return musiciens;
    }
 
 
    public Musicien getMusicienSelectionne() {
        return musicienSelectionne;
    }
 
    public void setMusicienSelectionne(Musicien musicienSelectionne) {
        this.musicienSelectionne = musicienSelectionne;
    }
    
    public void setMusiciens(List<Musicien> musiciens) {
        this.musiciens = musiciens;
    }

    
    
}