/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.gui.security;
import MeteoCal.business.security.boundary.UserManager;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;

import javax.inject.Named;

/**
 *
 * @author DeMaria
 */
@Named
@RequestScoped
public class UserBean{
    
    @EJB
    UserManager um;
    
    /**
     * constructor
     */
    public UserBean() {
    }
    /////////////////////METHODS//////////////////////////////
    
    /**
     * gives the name of the user connected
     * @return 
     */
    public String getName() {
        return um.getLoggedUser().getName();
    }
   
}
