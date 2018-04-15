package org.pis.bl;

import org.pis.entity.Department;
import org.pis.services.DepartmentService;
import org.primefaces.event.SelectEvent;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class DepartmentBean implements Serializable {
    private static final long serialVersionUID = 1L;

    @EJB
    private DepartmentService departmentService;

    private Department department;

    public Department getDepartment() {
        return department;
    }

    public Department findDepartment(Integer id) {
        return (Department) departmentService.find(Department.class, id);
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public DepartmentBean() {
        department = new Department();
    }

    public List<Department> getDepartments()
    {
        return departmentService.findAll(Department.class);
    }

    public void actionInsertNew(){
        departmentService.merge(department);
    }

    public void actionDelete(Department department){
        departmentService.remove(department);
    }

    public void onInsertDepartment(SelectEvent event){

    }

}
