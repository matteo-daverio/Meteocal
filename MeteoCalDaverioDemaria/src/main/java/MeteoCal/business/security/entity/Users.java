/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.business.security.entity;

import MeteoCal.business.security.control.PasswordEncrypter;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 *
 * @author DeMaria
 */
@Entity
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
   

    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)
    private String mail;
    

    private String name;
    

    private String psw;
    
    @NotNull(message = "May not be empty")
    private String groupName;
    
    @NotNull
    private boolean publicCalendar = false;
    
    
  ///COSTRUTTORI  
    
    public Users() {
    }
      
  ////GETTERS AND SETTERS
    
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = PasswordEncrypter.encryptPassword(psw);
    }

    public void setGroupName(String groupName) {
       this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }
    
    public boolean isPublicCalendar() {
        return publicCalendar;
    }

    public void setPublicCalendar(boolean publicCalendar) {
        this.publicCalendar = publicCalendar;
    }

    //////OVERRIDES
    
    @Override
    public String toString() {
        return mail;
    }
    
}
