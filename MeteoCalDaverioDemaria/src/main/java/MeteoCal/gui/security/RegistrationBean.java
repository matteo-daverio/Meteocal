/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.gui.security;

import MeteoCal.business.security.boundary.UserManager;
import MeteoCal.business.security.entity.Users;


/**
 *
 * @author Matteo
 */
public class RegistrationBean {
   
  private UserManager um;
  private Users user;
    
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

    public String register() {
        um.save(user);
        return "user/home?faces-redirect=true";
    }
} 
