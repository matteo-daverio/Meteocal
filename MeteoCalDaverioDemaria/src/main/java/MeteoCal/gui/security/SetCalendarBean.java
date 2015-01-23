/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.gui.security;

import MeteoCal.business.security.boundary.UserManagerInterface;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Matteo
 */
@Named
@RequestScoped
public class SetCalendarBean {
    
    @EJB
    UserManagerInterface um;
    
    private boolean status = true;
    
    
    /**
     * save user decision in db
     */
    public void saveDecision() {
        um.setCalendar(status, um.getLoggedUser());
    }
    
    /**
     * getter and setter
     * @param status
     */
    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isStatus() {
        return um.getLoggedUser().isPublicCalendar();
    }
}
