package org.pis.core;

import org.pis.entity.Employee;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;

@Named
@ApplicationScoped
public class AuthorizationBean implements Serializable {

    @Inject
    private AuthenticationBean authenticationBean;

    public AuthenticationBean getAuthenticationBean() {
        return authenticationBean;
    }

    public void setAuthenticationBean(AuthenticationBean authenticationBean) {
        this.authenticationBean = authenticationBean;
    }

    public boolean isUserInRole(String role){
        if(authenticationBean.getEmployee() == null || !authenticationBean.isAuthorized()){
            return false;
        }
        Employee e = authenticationBean.getEmployee();
        return e.getRole().equals(role);
    }

    public boolean isUserInRole(String role1, String role2){
        if(authenticationBean.getEmployee() == null || !authenticationBean.isAuthorized()){
            return false;
        }
        Employee e = authenticationBean.getEmployee();
        return e.getRole().equals(role1) || e.getRole().equals(role2);
    }
}
