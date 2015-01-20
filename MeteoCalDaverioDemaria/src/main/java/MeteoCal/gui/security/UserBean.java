/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.gui.security;

import MeteoCal.business.security.boundary.UserManager;
import javax.ejb.EJB;

/**
 *
 * @author DeMaria
 */
public class UserBean {
    
    @EJB
    UserManager um;
    
    public UserBean() {
    }
    //ritorna il nome dell'utente attualmente connesso
    public String getName() {
        return um.getLoggedUser().getName();
    }
    
    //TODO ritorno notifiche
    //TODO ritorno eventi
    //TODO ritorno numero notifiche+eventi
    
}
