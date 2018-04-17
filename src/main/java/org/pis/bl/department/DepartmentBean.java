package org.pis.bl.department;

import org.pis.bl.ViewPage;
import org.pis.entity.Department;
import org.pis.services.DepartmentService;
import org.primefaces.PrimeFaces;
import org.primefaces.event.SelectEvent;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ComponentSystemEvent;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ManagedBean
@SessionScoped
public class DepartmentBean extends ViewPage<Department> implements Serializable {
    private static final long serialVersionUID = 1L;

    @EJB
    private DepartmentService departmentService;

    private Department department;
    private List<Department> departments;

    public DepartmentBean()
    {
        department = new Department();
    }

    public void setDepartment(Department department)
    {
        this.department = department;
    }
    public Department getDepartment() {

        return department;
    }

    public Department findDepartment(Integer id)
    {
        return departmentService.find(Department.class, id);
    }

    private void loadDepartments(){
        departments = departmentService.findAll(Department.class);
    }

    @PostConstruct
    public void init(){
//        loadDepartments();
    }

    public List<Department> getDepartments()
    {
        return departmentService.findAll(Department.class);
    }

    public String actionNew(){
        department = new Department();
        return "department_insert_edit";
    }

    public String actionInsert(){
        this.department = departmentService.merge(department);
//        loadDepartments();

        return "departments";
    }

    public String actionEdit(Department department){
        setDepartment(department);
        return "department_insert_edit";
    }

    public String actionOpenDetail(Department department){
        setDepartment(department);
        return "department_detail";
    }

    public void chooseCar() {
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("resizable", false);
        options.put("draggable", true);
        options.put("modal", true);
        PrimeFaces.current().dialog().openDynamic("/test", options, null);
    }

    public void onCarChosen(SelectEvent event) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Car Selected", "Id");

        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void onDelete(SelectEvent event) {
        if((Boolean)event.getObject()){
            departmentService.remove(objectToDelete);
//            loadDepartments();
        }
        objectToDelete = null;
    }
}
