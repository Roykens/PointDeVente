package com.bracongo.pointdevente.dao.impl;

import com.bracongo.pointdevente.entities.PointDeVente;
import com.bracongo.pointdevente.dao.IPdvDao;
import com.bracongo.pointdevente.entities.PointDeVente_;
import com.royken.generic.dao.DataAccessException;
import com.royken.generic.dao.impl.GenericDao;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author Kenfack Valmy-Roi <roykenvalmy@gmail.com>
 */
public class PdvDaoImpl extends GenericDao<PointDeVente, Long> implements IPdvDao {

    @Override
    public List<PointDeVente> findByCriteria(String code, String brand, String circuit) throws DataAccessException {
        CriteriaBuilder cb = getManager().getCriteriaBuilder();
        CriteriaQuery<PointDeVente> cq = cb.createQuery(PointDeVente.class);
        Root<PointDeVente> pdvRoot = cq.from(PointDeVente.class);
        List<Predicate> predicates = new ArrayList<>();
        if (code != null) {
            predicates.add(cb.like(pdvRoot.get(PointDeVente_.code), code));
        }
        if (brand != null) {
            predicates.add(cb.like(pdvRoot.get(PointDeVente_.brand), brand));
        }
        if (circuit != null) {
            predicates.add(cb.like(pdvRoot.get(PointDeVente_.circuit), circuit));
        }
        cq.select(pdvRoot);
        if (predicates.size() > 0) {
            cq.where((predicates.size() == 1) ? predicates.get(0) : cb.and(predicates.toArray(new Predicate[0])));
        }
        return getManager().createQuery(cq).getResultList();
    }

}
