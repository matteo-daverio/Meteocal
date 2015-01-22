/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.business.security.boundary;

import MeteoCal.business.security.entity.Users;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author DeMaria
 */
@Remote
public interface UserManagerInterface {
   
    public void save(Users user) throws Exception;

    public void unregister();

    public Users getLoggedUser();

    public Users findByMail(String mail);

    public List<String> getListUsers();

    public List<String> getListUsersPublic();

    public void setCalendar(boolean status, Users user);

    
}
