package org.pis.services;

        import org.pis.entity.*;

        import javax.ejb.Stateless;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;

@Stateless
public class CommissionItemEmployeeService extends CrudService<CommissionItemEmployee> {

    public List<CommissionItemEmployee> findCommissionItemEmployees(CommissionItem commissionItem){
        return em.createQuery("SELECT ci.employeeList FROM CommissionItem ci WHERE ci = :comItem", CommissionItemEmployee.class)
                .setParameter("comItem", commissionItem)
                .getResultList();
    }

    public List<CommissionItemEmployee> findAllItemsByCommissionItem(CommissionItem commissionItem){
        return em.createQuery("SELECT item " +
                "FROM CommissionItemEmployee item " +
                "WHERE item.commissionItem.id = :commItem")
                .setParameter("commItem", commissionItem.getId())
                .getResultList();
    }

    public Map<Commission, List<CommissionItemEmployee>> findCommissionItemsByEmployee(Employee employee){
        HashMap<Commission, List<CommissionItemEmployee>> c = new HashMap<>();
        List<Commission> commissions = em.createQuery("SELECT item.commissionItem.commission " +
                "FROM CommissionItemEmployee item " +
                "WHERE item.employee.id = :empl group by item.commissionItem.commission")
                .setParameter("empl", employee.getId())
                .getResultList();

        for(Commission commission : commissions){
            List<CommissionItemEmployee> cie = em.createQuery("SELECT item " +
                    "FROM CommissionItemEmployee item " +
                    "WHERE item.employee.id = :empl AND item.commissionItem.commission.id = :comm")
                    .setParameter("empl", employee.getId())
                    .setParameter("comm", commission.getId())
                    .getResultList();
            c.put(commission, cie);
        }

        return c;
    }

}
