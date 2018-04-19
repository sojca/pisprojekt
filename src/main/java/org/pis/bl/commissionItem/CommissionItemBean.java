package org.pis.bl.commissionItem;


        import org.pis.bl.ViewPage;
        import org.pis.bl.commission.CommissionBean;
        import org.pis.entity.*;
        import org.pis.services.*;
        import org.primefaces.PrimeFaces;
        import org.primefaces.event.SelectEvent;

        import javax.annotation.PostConstruct;
        import javax.ejb.EJB;
        import javax.faces.application.FacesMessage;
        import javax.faces.bean.ManagedBean;
        import javax.faces.bean.ManagedProperty;
        import javax.faces.bean.SessionScoped;
        import javax.faces.context.FacesContext;
        import javax.faces.event.ComponentSystemEvent;
        import java.io.Serializable;
        import java.util.HashMap;
        import java.util.List;
        import java.util.Map;

@ManagedBean
@SessionScoped
public class CommissionItemBean extends ViewPage<CommissionItem> implements Serializable {
    private static final long serialVersionUID = 1L;

    @EJB
    private CommissionService commissionService;

    @EJB
    private ActivityService activityService;

    @EJB
    private CommissionItemService commissionItemService;

    private CommissionItem commissionItem;
    private Commission commission;
    private Activity activity;

    public double getSum(){
        List<CommissionItem> ci = getCommissionItems();
        double total = 0.0;
        for (CommissionItem item : ci){
            total+=item.getActivity().getPricePerUnit() * item.getAmount();
        }
        return total;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setCommission(Commission commission)
    {
        this.commission = commission;
    }
    public Commission getCommission() {

        return commission;
    }


    public  CommissionItemBean()
    {
        commissionItem = new CommissionItem();
    }

    public void setCommissionItem(CommissionItem commissionItem)
    {
        this.commissionItem = commissionItem;
    }
    public CommissionItem getCommissionItem() {

        return commissionItem;
    }

    @PostConstruct
    public void init(){
    }

    public List<CommissionItem> getCommissionItems(){
        List<CommissionItem> ci= commissionItemService.findCommissionItems(commission);
        ci.remove(null);

        return ci;
    }

    public Activity findActivity (int id) {
        return activityService.find(Activity.class, id);
    }

    public List<Activity> getActivities()
    {
        return activityService.findAll(Activity.class);
    }

    public Commission findCommission (int id) {
        return commissionService.find(Commission.class, id);
    }

    public List<Commission> getCommissions()
    {
        return commissionService.findAll(Commission.class);
    }

    public String actionNew(){
        commissionItem = new CommissionItem();
        return "commissionItem_insert_edit";
    }

    public String actionInsertNew(){
        commissionItem.setCommission(commission);
        commissionItem.setActivity(activity);
        commissionItemService.merge(commissionItem);
        commissionItem = new CommissionItem();

        return "commissionItems";
    }


    public String actionEdit(Commission commission){
        setCommission(commission);
        return "commission_insert_edit";
    }

    public String actionOpenDetail(Commission comm){
        commission=comm;
        commissionItem.setCommission(comm);
        return "commissionItems";
    }

    public void onDelete(SelectEvent event) {
        if((Boolean)event.getObject()){
            commissionItemService.remove(objectToDelete);
//            loadDepartments();
        }
        objectToDelete = null;
    }
}
