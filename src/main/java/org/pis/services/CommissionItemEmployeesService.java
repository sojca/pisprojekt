package org.pis.services;

import org.pis.entity.CommissionItem;
import org.pis.entity.Employee;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class CommissionItemEmployeesService extends CrudService<CommissionItemEmployeesService> {

    public List<CommissionItem> findCommissionItemsByEmployee(Employee employee){
        return em.createQuery("SELECT item.commissionItem " +
                "FROM CommissionItemEmployee item " +
                "WHERE item.employee = :empl")
                .setParameter("empl", employee)
                .getResultList();
    }
}
