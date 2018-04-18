package org.pis.services;

import org.pis.entity.Employee;

import javax.ejb.Stateless;
import java.util.List;

@Stateless
public class EmployeeService extends CrudService<Employee> {

    public List<Employee> getLastUsedUsername(Employee employee){
        return em.createQuery("SELECT e from Employee e WHERE e.login like :login order by e.login desc", Employee.class)
                .setParameter("login", employee.getLogin()+ "%")
                .setMaxResults(1)
                .getResultList();
    }

    public Employee getUserByLogin(String login){

        return em.createQuery("SELECT e from Employee e WHERE e.login = :login", Employee.class)
                .setParameter("login", login)
                .getSingleResult();
    }
}
