/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package MeteoCal.business.security.boundary;

import MeteoCal.business.security.entity.Calendar;
import MeteoCal.business.security.entity.Users;
import java.security.Principal;
import static java.util.Collections.list;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
/**
 *
 * @author DeMaria
 */
@Stateless
public class UserManager {
    
    @PersistenceContext
    EntityManager em;
   
    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    
    @Inject
    Principal principal;
    
    
    public Principal getPrincipal(){
        return principal;
    }
    
    public void setPrincipal(Principal principal){
        this.principal=principal;
    }
    
    Query query;
    
        public void save(Users users) {
        
        //creo un nuovo calendario    
        Calendar calendar =new Calendar();
        calendar.setIsPublic(Boolean.TRUE);
        
        //assegno al nuovo utente il calendario creato
        users.setCalendaridCalendar(calendar);
        
        //salvo calendario e utente
        em.persist(calendar);
        em.persist(users);
            
        
    }

    public void unregister() {
        em.remove(getLoggedUser());
    }

    //ritorna l'utente attualmente connesso
    public Users getLoggedUser() {
        return em.find(Users.class, principal.getName());
    }
    
    //cerca tutti gli utenti che hanno quel nome
    //e il loro calendario è pubblico
    public List<String> searchUsers(Users users){
        
      query= em.createQuery("SELECT u.name FROM users u WHERE u.name != name and u.idCalendar IN(SELECT c.idCalendar from calendar c WHERE c.isPublic=1) ").setParameter("name",users.getName());
      List<String> u;
      u=query.getResultList();
      return u;
    }  
    
    

    
}
