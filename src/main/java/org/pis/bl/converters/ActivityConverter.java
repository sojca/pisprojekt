package org.pis.bl.converters;

        import org.pis.bl.commission.CommissionItemBean;
        import org.pis.entity.Activity;

        import javax.el.ValueExpression;
        import javax.faces.component.UIComponent;
        import javax.faces.context.FacesContext;
        import javax.faces.convert.Converter;
        import javax.faces.convert.FacesConverter;

@FacesConverter(value = "activityConverter")
public class ActivityConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext facesContext, UIComponent uiComponent, String s) {
        ValueExpression vex =
                facesContext.getApplication().getExpressionFactory()
                        .createValueExpression(facesContext.getELContext(),
                                "#{commissionItemBean}", CommissionItemBean.class);

        CommissionItemBean commItemContext = (CommissionItemBean) vex.getValue(facesContext.getELContext());

        return commItemContext.findActivity(Integer.parseInt(s));
    }

    @Override
    public String getAsString(FacesContext facesContext, UIComponent uiComponent, Object o) {
        if(o == null){
            return null;
        }
        return String.valueOf(((Activity)o).getId());
    }
}
