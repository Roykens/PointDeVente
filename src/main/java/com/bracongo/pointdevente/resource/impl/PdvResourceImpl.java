package com.bracongo.pointdevente.resource.impl;

import com.bracongo.pointdevente.entities.PointDeVente;
import com.bracongo.pointdevente.resource.IPdvResource;
import com.bracongo.pointdevente.service.IPdvService;
import com.bracongo.pointdevente.service.ServiceException;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ws.rs.Path;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@Path("/pdv")
public class PdvResourceImpl implements IPdvResource{
    
    @EJB
    private IPdvService pdvService;

    /**
     *
     * @return la liste des points de vente
     */
    @Override
    public List<PointDeVente> getAllPointDeVente() {
        try {
            return pdvService.findAllPdv();
        } catch (ServiceException ex) {
            Logger.getLogger(PdvResourceImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Collections.emptyList();
    }
    
}
