package org.pis.services;

import org.pis.entity.Activity;
import org.pis.entity.Department;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class DepartmentService extends CrudService<Department> {

    public List<Activity> findActivities(Department department){
        return em.createQuery("SELECT c.activityList FROM Department c WHERE c = :dep", Activity.class)
                .setParameter("dep", department)
                .getResultList();
    }
}
