package org.pis.bl.common;

import org.pis.core.AuthenticationBean;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;

@ManagedBean
@ViewScoped
public class LogoutBean implements Serializable{

    private static final long serialVersionUID = 1L;

    @Inject
    private AuthenticationBean authenticationBean;

    private String loginPage = "login";

    public LogoutBean() {

    }

    @PostConstruct
    private void init(){
        authenticationBean.setAuthorized(false);
        authenticationBean.setEmployee(null);
    }

    public String getLoginPage() {
        return loginPage;
    }

    public void setLoginPage(String loginPage) {
        this.loginPage = loginPage;
    }

    public String actionLogout(){
        return "/logout";
    }
}
