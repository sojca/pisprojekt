package org.pis.bl.commission;


import org.pis.bl.ViewPage;
import org.pis.entity.Commission;
import org.pis.entity.Department;
import org.pis.services.CommissionService;
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
public class CommissionBean extends ViewPage<Commission> implements Serializable {
    private static final long serialVersionUID = 1L;

    @EJB
    private CommissionService commissionService;

    private Commission commission;
    private List<Commission> commissions;

    public  CommissionBean()
    {
        commission = new Commission();
    }

    public void setCommission(Commission commission)
    {
        this.commission = commission;
    }
    public Commission getCommission() {

        return commission;
    }

    /*
    private void loadCommissions(){
        commissions = commissionService.findAll(Commission.class);
    }
    */

    @PostConstruct
    public void init(){
//        loadCommisions();
    }

    public List<Commission> getCommissions()
    {
        return commissionService.findAll(Commission.class);
    }

    public String actionNew(){
        commission = new Commission();
        return "commission_insert_edit";
    }

    public String actionInsert(){
        commissionService.merge(commission);
//        loadDepartments();

        return "commissions";
    }

    public String actionEdit(Commission commission){
        setCommission(commission);
        return "commission_insert_edit";
    }

    public String actionOpenDetail(Commission commission){
        setCommission(commission);
        return "commission_detail";
    }

    public void onDelete(SelectEvent event) {
        if((Boolean)event.getObject()){
            commissionService.remove(objectToDelete);
//            loadDepartments();
        }
        objectToDelete = null;
    }
}