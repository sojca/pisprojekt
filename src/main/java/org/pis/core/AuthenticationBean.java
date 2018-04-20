package org.pis.core;


import org.pis.entity.Employee;
import org.pis.services.EmployeeService;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.NoResultException;
import java.io.Serializable;


@Named
@ApplicationScoped
public class AuthenticationBean implements Serializable
{
    private static final long serialVersionUID = 1L;

    @EJB
    private EmployeeService employeeService;

    @EJB
    private EmployeeUtils employeeUtils;

    private Employee employee;



    private boolean authorized;
    private String login;
    private String password;

    public AuthenticationBean()
    {
        setAuthorized(false);
    }

    public boolean isAuthorized()
    {
        return authorized;
    }

    public void setAuthorized(boolean authorized)
    {
        this.authorized = authorized;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


    public String actionLogin()
    {
        employeeService.findAll(Employee.class);
        try{
            Employee e = employeeService.getUserByLogin(login);
                if(employeeUtils.Hash(password).equals(e.getPassword())){
                    authorized = true;
                    employee = e;

                    return "logged";
                }
        }
        catch (NoResultException e){
        }
        catch (Exception e){

        }

        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error","Invalid login"));
        return "login_failed";
    }

    public String getLogoutPath(){
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        String path = ec.getRequestContextPath();
        return path.concat("/logout.xhtml");
    }

    public String getSessionTimeout(){
        return "600" ;
    }
}
