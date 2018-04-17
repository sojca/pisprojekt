package org.pis.bl.converters;

import org.pis.bl.employee.EmployeeBean;
import org.pis.entity.Department;
import org.pis.services.DepartmentService;

import javax.ejb.EJB;
import javax.el.ValueExpression;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(value = "departmentConverter")
public class DepartmentConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        ValueExpression vex =
                facesContext.getApplication().getExpressionFactory()
                        .createValueExpression(facesContext.getELContext(),
                                "#{employeeBean}", EmployeeBean.class);

        EmployeeBean emplContext = (EmployeeBean)vex.getValue(facesContext.getELContext());

        return emplContext.findDepartment(Integer.parseInt(s));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if(o == null){
            return null;
        }
        return String.valueOf(((Department)o).getId());
    }
}
