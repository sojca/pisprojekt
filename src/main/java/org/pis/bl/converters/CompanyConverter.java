package org.pis.bl.converters;

        import org.pis.bl.commission.CommissionBean;
        import org.pis.entity.Commission;
        import org.pis.entity.Company;

        import javax.ejb.EJB;
        import javax.el.ValueExpression;
        import javax.faces.component.UIComponent;
        import javax.faces.context.FacesContext;
        import javax.faces.convert.Converter;
        import javax.faces.convert.FacesConverter;

@FacesConverter(value = "companyConverter")
public class CompanyConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        ValueExpression vex =
                facesContext.getApplication().getExpressionFactory()
                        .createValueExpression(facesContext.getELContext(),
                                "#{commissionBean}", CommissionBean.class);

        CommissionBean commContext = (CommissionBean) vex.getValue(facesContext.getELContext());

        return commContext.findCompany(Integer.parseInt(s));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if(o == null){
            return null;
        }
        return String.valueOf(((Company)o).getId());
    }
}
