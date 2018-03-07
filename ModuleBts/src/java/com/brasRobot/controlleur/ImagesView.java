package com.brasRobot.controlleur;


 
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;


import javax.inject.Named;
 
@Named
@RequestScoped
public class ImagesView {
     
    private List<String> images;
     
    @PostConstruct
    public void init() {
       
        images = new ArrayList<String>();
      System.out.println("bonjour");
        for (int i = 1; i <= 12; i++) {
            images.add("nature" + i + ".jpg");
            System.out.println("bonjour");
        }
       
    }
    
 
    public List<String> getImages() {
       
        return images;
        }
}
