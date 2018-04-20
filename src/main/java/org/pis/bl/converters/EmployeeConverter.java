package org.pis.bl.converters;

        import org.pis.bl.commission.CommissionItemEmployeeBean;
        import org.pis.entity.Employee;

        import javax.el.ValueExpression;
        import javax.faces.component.UIComponent;
        import javax.faces.context.FacesContext;
        import javax.faces.convert.Converter;
        import javax.faces.convert.FacesConverter;

@FacesConverter(value = "employeeConverter")
public class EmployeeConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        ValueExpression vex =
                facesContext.getApplication().getExpressionFactory()
                        .createValueExpression(facesContext.getELContext(),
                                "#{commissionItemEmployeeBean}", CommissionItemEmployeeBean.class);

        CommissionItemEmployeeBean commItemEmplContext = (CommissionItemEmployeeBean) vex.getValue(facesContext.getELContext());

        return commItemEmplContext.findEmployee(Integer.parseInt(s));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if(o == null){
            return null;
        }
        return String.valueOf(((Employee)o).getId());
    }
}
