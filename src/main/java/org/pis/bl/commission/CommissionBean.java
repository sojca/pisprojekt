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
    private List<Commission> commissions;

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

    @PostConstruct
    public void init(){
        filterAll();
    }
    public void setCommission(Commission commission)
    {
        this.commission = commission;
    }
    public Commission getCommission() {

        return commission;
    }

    public Company findCompany (int id) {
        return companyService.find(Company.class, id);
    }

    public List<Commission> getCommissions()
    {
        return commissions;
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

    public void filterFinished(){
        commissions = commissionService.getFinished();
    }
    public void filterAll(){
        commissions = commissionService.findAll(Commission.class);
    }

    public void onDelete(SelectEvent event) {
        if((Boolean)event.getObject()){
            commissionService.remove(objectToDelete);
        }
        objectToDelete = null;
    }
}