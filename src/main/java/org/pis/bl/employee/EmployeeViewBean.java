package org.pis.bl.employee;

import org.pis.core.AuthenticationBean;
import org.pis.entity.Commission;
import org.pis.entity.CommissionItem;
import org.pis.entity.Employee;
import org.pis.services.CommissionItemEmployeesService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@SessionScoped
public class EmployeeViewBean {

    @EJB
    private CommissionItemEmployeesService commissionItemEmployeesService;

    @Inject
    private AuthenticationBean authenticationBean;

    public EmployeeViewBean() {
    }

    public List<CommissionItem> getCommissionItems(Employee employee){
        Employee a = authenticationBean.getEmployee();
        return commissionItemEmployeesService.findCommissionItemsByEmployee(employee);
    }

}
