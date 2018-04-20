package org.pis.bl.commission;


import org.pis.bl.ViewPage;
import org.pis.entity.Commission;
import org.pis.entity.Company;
import org.pis.services.CommissionService;
import org.pis.services.CompanyService;
import org.primefaces.event.SelectEvent;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@ViewScoped
public class CommissionBean extends ViewPage<Commission> implements Serializable {
    private static final long serialVersionUID = 1L;

    @EJB
    private CommissionService commissionService;

    @EJB
    private CompanyService companyService;

    private Company company;
    private Commission commission;

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }


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

    @PostConstruct
    public void init(){
//        loadCommisions();
    }

    public Company findCompany (int id) {
        return companyService.find(Company.class, id);
    }

    public List<Commission> getCommissions()
    {
        return commissionService.findAll(Commission.class);
    }

    public List<Company> getCompanies()
    {
        return companyService.findAll(Company.class);
    }

    public String actionNew(){
        commission = new Commission();
        return "commission_insert_edit";
    }

    public String actionInsertNew(){
        commission.setCompany(company);
        commissionService.merge(commission);
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