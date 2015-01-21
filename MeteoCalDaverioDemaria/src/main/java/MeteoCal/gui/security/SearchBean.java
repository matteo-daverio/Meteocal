/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.gui.security;

import MeteoCal.business.security.boundary.UserManager;
import MeteoCal.business.security.entity.Users;
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
    
      @EJB
      private UserManager um;
      
      private Users user;
      
      
      private String value; //stringa per autocomplete
      
    public SearchBean(){}
    
    public Users getUser() {
        if (user == null) {
            user = new Users();
        }
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public List<String> complete(String query){
        
        return um.complete(value);
        
    }
    
    //restituisce gli utenti che hanno quel nome
    public List<Users>Search(){
     
    return um.searchUsers(user);
    
    //
    
    }
    
    public void setValue(String value) {
        this.value = value;
    }
 
    public String getValue() {
        return value;
    }
    
}
