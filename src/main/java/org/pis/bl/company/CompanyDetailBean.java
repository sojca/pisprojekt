package org.pis.bl.company;

import org.pis.bl.department.DepartmentBean;
import org.pis.entity.Company;
import org.pis.services.CompanyService;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

@ManagedBean
@ViewScoped
public class CompanyDetailBean implements Serializable {

    private Company company;

    @ManagedProperty("#{companyBean}")
    private CompanyBean companyBean;

    @EJB
    private CompanyService companyService;

    public void setCompanyBean(CompanyBean companyBean) {
        this.companyBean = companyBean;
    }

    public Company getCompany() {
        return company;
    }

    @PostConstruct
    private void init(){
        company = companyBean.getCompany();
    }

    public String actionOpenEdit()
    {
        return "company_insert_edit";
    }
}
