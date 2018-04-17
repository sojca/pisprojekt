package org.pis.bl;

import org.primefaces.PrimeFaces;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;


public class ViewPage<T> implements Serializable {

    protected T objectToDelete;

    public void openDeleteDialog(T o) {
        this.objectToDelete = o;

        Map<String,Object> options = new HashMap<String, Object>();
        options.put("resizable", false);
        options.put("draggable", true);
        options.put("modal", true);
        PrimeFaces.current().dialog().openDynamic("/delete_dialog", options, null);
    }
}
