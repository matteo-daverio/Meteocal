/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.gui.security;

import MeteoCal.business.security.boundary.EventManager;
import MeteoCal.business.security.entity.Event;
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
public class SearchBean {
    
    
    ///FIELDS
    
      @EJB
      private EventManager em;
      
      private String user_mail;
      
     
     ///GETTERS AND SETTERS 
      public EventManager get_em(){
          return this.em;
      }
      
      public void set_em(EventManager em){
          this.em=em;
      }
      
      public String get_user_mail(){
          return this.user_mail;
      }
      
      public void  set_user_mail(String mail){
          this.user_mail = mail;
      }
      
   
    //CONSTRUCTORS  
    public SearchBean(){}
    
    
    /**
     * given a mail it return the public events of that user
     * @return 
     */
    public List<Event> Search(){
    return  em.loadPublicCalendar(user_mail);
 
    
    //
    
    }
    
}
