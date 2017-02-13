package com.bracongo.pointdevente.resource;

import com.bracongo.pointdevente.entities.PointDeVente;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author vr.kenfack
 */
@Path("/pdv")
public interface IPdvResource {
    
    @GET
    @Produces(value = "application/json")
    public List<PointDeVente> getAllPointDeVente();
}
