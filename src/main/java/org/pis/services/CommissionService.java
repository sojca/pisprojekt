package org.pis.services;

import org.pis.entity.Activity;
import org.pis.entity.Commission;
import org.pis.entity.CommissionItem;
import org.pis.entity.Department;
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class CommissionService extends CrudService<Commission> {
    public boolean hasOnlyFinishedItems(Commission c){
        List<CommissionItem> cis = em.createQuery("SELECT c.CommissionItems " +
                "FROM Commission c inner join CommissionItem ci on c.id = ci.commission.id " +
                "WHERE ci.status = 'finished'")
                .getResultList();

        return cis.size() == c.getCommissionItems().size();
    }
}


