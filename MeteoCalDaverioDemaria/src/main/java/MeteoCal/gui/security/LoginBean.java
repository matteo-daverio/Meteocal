/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.gui.security;

import MeteoCal.business.security.boundary.UserManagerInterface;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author DeMaria
 */
@Named("loginBean")
@RequestScoped
@Stateful
public class LoginBean {
    
    @EJB
    UserManagerInterface um;    

    private String username;
    private String password;

    public LoginBean() {
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Return email of logged User
     *
     * @return
     */
    public String getName() {
        return um.getLoggedUser().getMail();
    }
    
    public String login() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        try {
            request.login(this.username, this.password);
        } catch (ServletException e) {
            context.addMessage(null, new FacesMessage("Login Failed"));
            return "";
        }
        
        return "home?faces-redirect=true";
    }
    public String logout() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        try{
            request.logout();
        } catch(ServletException e){
            context.addMessage(null, new FacesMessage("Logout Failed"));
        }
        return "index?faces-redirect=true";
    }
}
