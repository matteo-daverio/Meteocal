/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.gui.security;

import MeteoCal.business.security.boundary.UserManager;
import MeteoCal.business.security.entity.Invitation;
import MeteoCal.business.security.entity.Notification;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author DeMaria
 */
@Named
@RequestScoped
public class UserBean {
    
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
    
    //TODO ritorno notifiche
    public List<Notification> getNotifications(){
       List<Notification> x=null;
       return  x;
    }
    
    
    
    //TODO ritorno inviti
    public List<Invitation> getInvitations(){
      List<Invitation> x=null;
       return  x;  
    }
    //TODO ritorno numero notifiche+inviti
    public Integer getNumberNotificationInvitation(){
              Integer x=null;
       return  x; 
    }
    //TODO ritorna lo stato della privacy del calendario
    public boolean getStatusCalendar(){
        return true;
    }
    //TODO cambiare setting privacy calendario
    public void changeStatusCalendar(){
       
    }
}
