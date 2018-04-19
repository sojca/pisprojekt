package org.pis.bl.employee;

import org.pis.core.AuthenticationBean;
import org.pis.entity.CommissionItem;
import org.pis.entity.Employee;
import org.pis.services.CommissionItemEmployeeService;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;
import java.util.List;

@ManagedBean
@SessionScoped
public class EmployeeViewBean {

    @EJB
    private CommissionItemEmployeeService commissionItemEmployeeService;

    @Inject
    private AuthenticationBean authenticationBean;

    public EmployeeViewBean() {
    }

    public List<CommissionItem> getCommissionItems(Employee employee){
        Employee a = authenticationBean.getEmployee();
        return commissionItemEmployeeService.findCommissionItemsByEmployee(employee);
    }

}
