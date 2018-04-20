package org.pis.services;

import org.pis.entity.Department;
import org.pis.entity.Employee;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class EmployeeService extends CrudService<Employee> {

    public List<Employee> getLastUsedUsername(String employeeLogin){
        employeeLogin = employeeLogin.concat("%");
        List<Employee> l =  em.createQuery("SELECT e from Employee e WHERE e.login like :login order by e.login desc")
                .setParameter("login", employeeLogin)
                .setMaxResults(1)
                .getResultList();
        return l;
    }

    public Employee getUserByLogin(String login){

        return em.createQuery("SELECT e from Employee e WHERE e.login = :login", Employee.class)
                .setParameter("login", login)
                .getSingleResult();
    }

    public List<Employee> getEmployeesByDepartment(Department department){
        return em.createQuery("SELECT e from Employee e WHERE e.department = :dep")
                .setParameter("dep", department)
                .getResultList();
    }
}
