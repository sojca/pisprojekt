package org.pis.bl.commission;

        import org.pis.bl.ViewPage;
        import org.pis.bl.commission.CommissionBean;
        import org.pis.entity.*;
        import org.pis.services.*;
        import org.primefaces.PrimeFaces;
        import org.primefaces.event.SelectEvent;

        import javax.annotation.PostConstruct;
        import javax.ejb.EJB;
        import javax.faces.application.FacesMessage;
        import javax.faces.bean.ManagedBean;
        import javax.faces.bean.ManagedProperty;
        import javax.faces.bean.SessionScoped;
        import javax.faces.context.FacesContext;
        import javax.faces.event.ComponentSystemEvent;
        import java.io.Serializable;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;

@ManagedBean
@SessionScoped
public class CommissionItemEmployeeBean extends ViewPage<CommissionItemEmployee> implements Serializable {
    private static final long serialVersionUID = 1L;

    @EJB
    private CommissionItemService commissionItemService;

    @EJB
    private EmployeeService employeeService;

    @EJB
    private CommissionItemEmployeeService commissionItemEmployeeService;

    private CommissionItem commissionItem;
    private Employee employee;
    private CommissionItemEmployee commissionItemEmployee;

    public void setEmployee(Employee employee) {

        this.employee = employee;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setCommissionItem(CommissionItem commissionItem)
    {
        this.commissionItem = commissionItem;
    }
    public CommissionItem getCommissionItem() {

        return commissionItem;
    }


    public  CommissionItemEmployeeBean()
    {
        commissionItemEmployee = new CommissionItemEmployee();
    }

    @PostConstruct
    public void init(){
    }

    public List<CommissionItemEmployee> getCommissionItemEmployees(){
        List<CommissionItemEmployee> ci= commissionItemEmployeeService.findCommissionItemEmployees(commissionItem);
        ci.remove(null);
        return ci;
    }

    public Employee findEmployee (int id) {
        Employee e = employeeService.find(Employee.class, id);
        return e;
    }

    public List<Employee> getEmployees()
    {
        Department department = getCommissionItem().getActivity().getDepartment();
        return employeeService.getEmployeesByDepartment(department);
    }

    public CommissionItem findCommissionItem (int id) {
        return commissionItemService.find(CommissionItem.class, id);
    }

    public List<CommissionItem> getCommissionItems()
    {
        return commissionItemService.findAll(CommissionItem.class);
    }

    public double calculateCommissionItemExpenses(CommissionItemEmployee cie){
        double expenses = 0.0;
        expenses += cie.getRealHour() * (cie.getCommissionItem().getActivity().getDuration() /
                cie.getCommissionItem().getActivity().getPricePerUnit());
        return expenses;
    }

    public String actionNew(){
        commissionItemEmployee = new CommissionItemEmployee();
        return "commissionItem_insert_edit";
    }

    public String actionInsertNew(){
        commissionItemEmployee.setCommissionItem(commissionItem);
        commissionItemEmployee.setEmployee(employee);
        commissionItemEmployeeService.merge(commissionItemEmployee);
        commissionItemEmployee = new CommissionItemEmployee();
        return "itemAssignedEmployee";
    }

    public String actionOpenDetail(CommissionItem ci){
        commissionItem=ci;
        commissionItemEmployee.setCommissionItem(ci);
        return "itemAssignedEmployee";
    }

    public void onDelete(SelectEvent event) {
        if((Boolean)event.getObject()){
            commissionItemEmployeeService.remove(objectToDelete);
//            loadDepartments();
        }
        objectToDelete = null;
    }
}
