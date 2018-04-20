package org.pis.bl.employee;

import org.pis.core.AuthenticationBean;
import org.pis.entity.*;
import org.pis.services.CommissionItemEmployeeService;
import org.pis.services.CommissionItemService;
import org.primefaces.PrimeFaces;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.persistence.PostLoad;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ManagedBean
@ViewScoped
public class EmployeeViewBean implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private CommissionItemEmployeeService commissionItemEmployeeService;

    @EJB
    private CommissionItemService commissionItemService;

    private Employee employee;
    private CommissionItemEmployee itemToUpdate;
    private float hours;

    private Map<Commission, List<CommissionItemEmployee>> commissionItemEmployee;

    @Inject
    private AuthenticationBean authenticationBean;

    public EmployeeViewBean() {
    }

    @PostConstruct
    public void init(){

        employee = authenticationBean.getEmployee();
        if(employee == null){
            commissionItemEmployee = new HashMap<>();
        }
        else{
            commissionItemEmployee = commissionItemEmployeeService.findCommissionItemsByEmployee(employee);
        }
    }

    public List<Commission> getCommissions(){
        return new ArrayList<>(commissionItemEmployee.keySet());
    }

    public List<CommissionItemEmployee> getItemsByCommission(Commission commission){
        return commissionItemEmployee.get(commission);
    }

    public float getHours() {
        return hours;
    }

    public void setHours(float hours) {
        this.hours = hours;
    }

    public float getHoursDone(CommissionItemEmployee item){
        List<CommissionItemEmployee> allItems = commissionItemEmployeeService.findAllItemsByCommissionItem(item.getCommissionItem());
        float hours = 0;

        for(CommissionItemEmployee actualItem : allItems){
            hours += actualItem.getRealHour();
        }

        return hours;
    }

    public String getUnique(CommissionItemEmployee item){

        return String.valueOf(item.getCommissionItem().getId()).concat(String.valueOf(item.getEmployee().getId()));
    }
    public String actionInsertHours(CommissionItemEmployee item){

        return "employee_commission_detail";
    }

    public void openDialog(CommissionItemEmployee item){
        itemToUpdate = item;
        Map<String,Object> options = new HashMap<String, Object>();
        options.put("resizable", false);
        options.put("draggable", false);
        options.put("modal", true);
        options.put("contentWidth", "100%");
        options.put("contentHeight", "100%");
        PrimeFaces.current().dialog().openDynamic("update_hours", options, null);
    }

    public void onUpdateHours(SelectEvent event) {
        float hours = (float) event.getObject();
        itemToUpdate.setRealHour(itemToUpdate.getRealHour()+hours);
        commissionItemEmployeeService.merge(itemToUpdate);
        itemToUpdate = null;
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect("employee_commission_detail.xhtml");
        }
        catch (IOException e){}
    }

}
