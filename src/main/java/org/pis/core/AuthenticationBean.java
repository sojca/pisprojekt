package org.pis.core;


import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import java.io.Serializable;


@Named
@SessionScoped
public class AuthenticationBean implements Serializable
{
    private static final long serialVersionUID = 1L;

    private boolean authorized;
    private String login;
    private String password;

    public AuthenticationBean()
    {
        authorized = false;
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

    public String actionLogout()
    {
        authorized = false;
        return "logout";
    }

    public String actionLogin()
    {
        if (login.equals("admin") && password.equals("admin"))
        {
            authorized = true;
            return "logged";
        }
        else
        {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error","Invalid login"));
            return "login_failed";
        }
    }
}
