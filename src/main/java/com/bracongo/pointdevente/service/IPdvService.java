package com.bracongo.pointdevente.service;

import com.bracongo.pointdevente.entities.PointDeVente;
import com.bracongo.pointdevente.service.util.ImportationResult;
import java.io.InputStream;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
@Local
public interface IPdvService {
    
    public void createOrUpdatePdv(PointDeVente pointDeVente) throws ServiceException;
    
    public PointDeVente findById(Long id) throws ServiceException;
    
    public List<PointDeVente> findAllPdv() throws ServiceException;
    
    public List<PointDeVente> findByCriteria() throws ServiceException; 
    
    public ImportationResult importPdv(InputStream stream) throws ServiceException;
}
