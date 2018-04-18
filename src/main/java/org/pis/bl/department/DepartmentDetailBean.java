package org.pis.bl.department;

import org.pis.bl.ViewPage;
import org.pis.entity.Activity;
import org.pis.entity.Department;
import org.pis.services.ActivityService;
import org.pis.services.DepartmentService;
import org.primefaces.event.SelectEvent;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.List;

@ManagedBean
@SessionScoped
public class DepartmentDetailBean  extends ViewPage<Activity> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Activity activity;

    @EJB
    private DepartmentService departmentService;

    @EJB
    private ActivityService activityService;


    @ManagedProperty("#{departmentBean}")
    private DepartmentBean departmentBean;


    public DepartmentDetailBean() {
        this.activity = new Activity();
    }

    public void setDepartmentBean(DepartmentBean departmentBean) {
        this.departmentBean = departmentBean;
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }

    public String actionAddActivity(){
        activity.setDepartment(departmentBean.getDepartment());
        activityService.merge(activity);

        return "department_detail";
    }

    public String actionInsertActivity(){
        this.activity = activityService.merge(activity);

        return "department_detail";
    }


    public List<Activity> getActivities() {

        List<Activity> act = departmentService.findActivities(departmentBean.getDepartment());
        act.remove(null);

        return act;
    }

    public String actionOpenEdit(){
        return "department_insert_edit";
    }

    public String actionEdit(){
        //departmentService.merge(departmentBean.getDepartment());
        return "department_detail";
    }

    public String actionOpenEditActivity(Activity activity){
        setActivity(activity);
        return "activity_edit";
    }

    public void onDelete(SelectEvent event) {
        if((Boolean)event.getObject()){
            activityService.remove(objectToDelete);
        }
        objectToDelete = null;
    }


}
