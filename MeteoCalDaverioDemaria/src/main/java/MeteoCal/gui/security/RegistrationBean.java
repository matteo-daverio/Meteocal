/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.gui.security;


import MeteoCal.business.security.boundary.UserManager;
import MeteoCal.business.security.entity.Users;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;





/**
 *
 * @author Matteo
 */
@Named
@RequestScoped
public class RegistrationBean {
  
  @EJB
  private UserManager um;
  
  
  private Users user=new Users();
    
    public RegistrationBean() {
    }

    public Users getUser() {
        if (user == null) {
            user = new Users();
        }
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    /**
     * registers the new user and his calendar
     * @return 
     */
    public String register() {
       try{ 
        um.save(user);
        return "index.xhtml?faces-redirect=true";
       } catch (Exception e) {
      FacesContext context = FacesContext.getCurrentInstance(); 
       context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Username Already USED"));
    return "";
       }
    }

} 
