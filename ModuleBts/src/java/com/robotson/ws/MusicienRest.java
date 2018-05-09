package com.robotson.ws;
import com.robotson.ejb.MusicienEJB;
import com.robotson.javabeans.Musicien;
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

@Path("/musicien")
@RequestScoped
@Produces({"application/json"})
public class MusicienRest {
    
    //Ejb
    @EJB
    private MusicienEJB musicienEjb;
 
    //test  Ok
    @GET
    @Path("/test")
    @Produces({"text/plain"})
    public String test() {
        return "Serveur OK";
    }   

    //liste Musicien  Ok
    @GET
    @Path("/liste")
    //@Produces({"application/json"})
    public List<Musicien> getListerMusicien() {
        System.out.println("Ok ");
        return this.musicienEjb.lister();
    }
    
    //ajouter  
    @POST  
    @Consumes({"application/json"})
    @Path("/ajouter")
    public List<Musicien> ajouterMusicien(Musicien m) {
        musicienEjb.editerMusicienEjb(m);
        return musicienEjb.lister();
    }
    
    
    //modifier
    @PUT
    @Path("/modifier")
    @Consumes({"application/json"})
    public Response modifierMusicien(Musicien m)
    {
        musicienEjb.editerMusicienEjb(m);
        Response response = Response.status(200).build();
        return response;
    }
    
    //supprimmer
    @DELETE
    @Path("supprimer/{idMusicien:[0-9]+}")
    public Response supprimerMusicien(@PathParam("idMusicien") int id)  
    {
        Musicien m = musicienEjb.getMusicienById(id);                      
        musicienEjb.supprimer(m);                                     
        Response reponse = Response.status(200).build();            
        return reponse;              
    }
    

}
