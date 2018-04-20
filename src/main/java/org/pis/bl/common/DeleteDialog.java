package org.pis.bl.common;

import org.primefaces.PrimeFaces;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;

@ManagedBean
@ViewScoped
public class DeleteDialog implements Serializable {

    public void deleteItem() {
        PrimeFaces.current().dialog().closeDynamic(true);
    }

    public void cancel(){
        PrimeFaces.current().dialog().closeDynamic(false);
    }
}
