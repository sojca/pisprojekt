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

    public boolean isUserInRole(String role){
        if(authenticationBean.getEmployee() == null || !authenticationBean.isAuthorized()){
            return false;
        }
        Employee e = authenticationBean.getEmployee();
        return e.getRole().equals(role);
    }
}
