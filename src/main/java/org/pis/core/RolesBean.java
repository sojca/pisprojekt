package org.pis.core;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@ApplicationScoped
public class RolesBean {

    public Roles[] getRoles(){
        return Roles.values();
    }
}