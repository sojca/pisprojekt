package org.pis.bl;

import org.pis.entity.Department;
import org.pis.entity.Employee;
import org.pis.services.DepartmentService;
import org.pis.services.EmployeeService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@SessionScoped
public class EmployeeBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private EmployeeService employeeService;

    @EJB
    private DepartmentService departmentService;

    private Employee employee;
    private Department department;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmployeeBean() {
        employee = new Employee();
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Employee> getEmployees(){
        return employeeService.findAll(Employee.class);
    }

    public Department getDepartment() {
        return department;
    }

    public Department findDepartment(int id) {
        return (Department) departmentService.find(Department.class, id);
    }

    public List<Department> getDepartments() {
        return departmentService.findAll(Department.class);
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String actionInsertNew(){
        employee.setDepartment(department);
        employeeService.merge(employee);
//        PrimeFaces.current().dialog().closeDynamic(null);

        return "employee";
    }

    public void actionDelete(Employee employee){
        employeeService.remove(employee);
    }

}
