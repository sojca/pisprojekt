package org.pis.bl.company;

import org.pis.bl.ViewPage;
import org.pis.entity.Company;
import org.pis.services.CompanyService;
import org.primefaces.event.SelectEvent;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@SessionScoped
public class CompanyBean extends ViewPage<Company> implements Serializable{

    private Company company;

    @EJB
    private CompanyService companyService;

    public CompanyBean() {
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public List<Company> getCompanies(){
        return companyService.findAll(Company.class);
    }

    public String actionOpenDetail(Company company){
        setCompany(company);
        return "company_detail";
    }

    public String actionNew(){
        company = new Company();
        return "company_insert_edit";
    }

    public void onDelete(SelectEvent event) {
        if((Boolean)event.getObject()){
            companyService.remove(objectToDelete);
        }
        objectToDelete = null;
    }

    public String actionInsert(){
        companyService.merge(company);

        return "companies";
    }

}
