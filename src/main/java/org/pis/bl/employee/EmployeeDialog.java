package org.pis.bl.employee;

import org.primefaces.PrimeFaces;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

@ManagedBean
@ViewScoped
public class EmployeeDialog implements Serializable {
    public void update(float hours) {
        PrimeFaces.current().dialog().closeDynamic(hours);
    }

    public void cancel(){
        PrimeFaces.current().dialog().closeDynamic(0.0);
    }
}
