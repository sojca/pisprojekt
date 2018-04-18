package org.pis.services;

import org.pis.entity.Commission;
import org.pis.entity.CommissionItem;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class CommissionItemService extends CrudService<CommissionItem> {

    public List<CommissionItem> findCommissionItems(Commission commission){
        return em.createQuery("SELECT c.CommissionItems FROM Commission c WHERE c = :com", CommissionItem.class)
                .setParameter("com", commission)
                .getResultList();
    }

}
