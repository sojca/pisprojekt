package org.pis.bl.converters;

        import org.pis.bl.commissionItem.CommissionItemBean;
        import org.pis.entity.Activity;
        import org.pis.entity.Commission;

        import javax.el.ValueExpression;
        import javax.faces.component.UIComponent;
        import javax.faces.context.FacesContext;
        import javax.faces.convert.Converter;
        import javax.faces.convert.FacesConverter;

@FacesConverter(value = "commissionConverter")
public class CommissionConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        ValueExpression vex =
                facesContext.getApplication().getExpressionFactory()
                        .createValueExpression(facesContext.getELContext(),
                                "#{commissionItemBean}", CommissionItemBean.class);

        CommissionItemBean commItemContext = (CommissionItemBean) vex.getValue(facesContext.getELContext());

        return commItemContext.findCommission(Integer.parseInt(s));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if(o == null){
            return null;
        }
        return String.valueOf(((Commission)o).getId());
    }
}
