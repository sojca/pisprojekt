package org.pis.bl.employee;

import org.pis.core.AuthenticationBean;
import org.pis.entity.CommissionItem;
import org.pis.entity.CommissionItemEmployee;
import org.pis.entity.Employee;
import org.pis.services.CommissionItemEmployeeService;
import org.pis.services.CommissionItemService;

import javax.annotation.PostConstruct;
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

    @EJB
    private CommissionItemService commissionItemService;

    private Employee employee;

    @Inject
    private AuthenticationBean authenticationBean;

    public EmployeeViewBean() {
    }

    @PostConstruct
    public void init(){
        employee = authenticationBean.getEmployee();
    }

    public List<CommissionItemEmployee> getCommissionItems(){
        return commissionItemEmployeeService.findCommissionItemsByEmployee(employee);
    }

}
