package com.bracongo.pointdevente.dao;

import com.bracongo.pointdevente.entities.PointDeVente;
import com.royken.generic.dao.DataAccessException;
import com.royken.generic.dao.IGenericDao;
import java.util.List;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
public interface IPdvDao extends IGenericDao<PointDeVente, Long>{
    
    public List<PointDeVente> findByCriteria(String code, String brand, String circuit) throws DataAccessException;
    
}
