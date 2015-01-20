/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.gui.security;

import MeteoCal.business.security.boundary.EventManager;
import java.io.Serializable;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author DeMaria
 */
@SessionScoped
@Named
public class EventBean implements Serializable {
    
    private EventManager em;
    
    public EventBean(){
        
    }
    
    
    
}
