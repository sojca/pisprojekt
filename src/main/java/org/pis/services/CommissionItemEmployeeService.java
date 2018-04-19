package org.pis.services;

        import org.pis.entity.CommissionItem;
        import org.pis.entity.CommissionItemEmployee;
        import org.pis.entity.Employee;

        import javax.ejb.Stateless;
        import java.util.List;

@Stateless
public class CommissionItemEmployeeService extends CrudService<CommissionItemEmployee> {

    public List<CommissionItemEmployee> findCommissionItemEmployees(CommissionItem commissionItem){
        return em.createQuery("SELECT ci.employeeList FROM CommissionItem ci WHERE ci = :comItem", CommissionItemEmployee.class)
                .setParameter("comItem", commissionItem)
                .getResultList();
    }

    public List<CommissionItemEmployee> findCommissionItemsByEmployee(Employee employee){
        return em.createQuery("SELECT item " +
                "FROM CommissionItemEmployee item " +
                "WHERE item.employee = :empl")
                .setParameter("empl", employee)
                .getResultList();
    }

}
