package com.robotson.ws;

import com.robotson.ejb.PreferenceEJB;
import com.robotson.javabeans.Preference;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/preference")
@RequestScoped
@Produces({"application/json"})
public class PreferenceRest {
 
    //Ejb
    @EJB
    private PreferenceEJB preferenceEjb;
 
    //test
    @GET
    @Path("/test")
    @Produces({"text/plain"})
    public String test() {
        return "Serveur OK";
    }   

    //liste Musicien
    @GET
    @Path("/liste")
    //@Produces({"application/json"})
    public List<Preference> getListerPreference() {
        System.out.println("Ok ");
        return this.preferenceEjb.getListerPreference();
    }
    
    //ajouter Error 405
    @POST
    @Path("/ajouter")
    public List<Preference> ajouterPreference(Preference p) {
        preferenceEjb.editerPreferenceEjb(p);
        return preferenceEjb.getListerPreference();
    }
    
    
    //modifier
      @PUT
    @Path("/modifier")
    @Consumes({"application/json"})
    public Response modifierPreference(Preference p)
    {
        preferenceEjb.editerPreferenceEjb(p);
        Response response = Response.status(200).build();
        return response;
    }
    
    //supprimmer
    @DELETE
    @Path("supprimer/{idPreference:[0-9]+}")
    public Response supprimerPreference(@PathParam("idPreference") int id)  
    {
        Preference p = preferenceEjb.getPreferenceById(id);                      
        preferenceEjb.supprimer(p);                                     
        Response reponse = Response.status(200).build();            
        return reponse;              
    }
}