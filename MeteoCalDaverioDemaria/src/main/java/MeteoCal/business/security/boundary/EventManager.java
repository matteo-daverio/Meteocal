/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.business.security.boundary;

import MeteoCal.business.security.entity.Event;
import MeteoCal.business.security.entity.Users;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author DeMaria
 */
public class EventManager {
   
    @PersistenceContext
    private EntityManager em;

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }
    
    @Inject
    Principal principal;//rappresenta il chiamante, viene iniettata ad ogni nuova chiamata
    
    

/////////////////////////////methods //////////////////////////////
    
    //
    public List<Event> loadCalendar(Users user) {

        
        //TODO fare la query per prendere tutti gli eventi del calendario di un utente
        Query query = em.createQuery("");
        List<Event> eventSet = new ArrayList<>(query.getResultList());

        return eventSet;
    }
    
    //carica il calendario pubblico di un utente
    public List<Event> loadPublicCalendar(String username) {

        //TODO
        Query query = em.createQuery("");
        List<Event> eventSet = new ArrayList<>(query.getResultList());

        return eventSet;
    }
    
    
    public boolean eventIsPublic(Event event){
    
        Query query=em.createQuery("SELECT e FROM event e WHERE e =:event").setParameter("event", event);
        List<Event> result= new ArrayList<>(query.getResultList());
        return result.get(0).getIsPublic();
        
    }
    
    //
    public boolean isIndoor(Event event) {
        
        Query query = em.createQuery("SELECT e FROM event e WHERE e= :event").setParameter("event", event);
        List<Event> result = new ArrayList<>(query.getResultList());
        return !result.get(0).getIsOutdoor();
    }

    //
    public void removeEvent(Event event) {
   Query query1 = em.createQuery("Delete From event e Where e = :event").setParameter(("event"), event);
        query1.executeUpdate();
       
     }
    
    //
    public void addEvent(Event event){
     em.persist(event);
    }
    


 
}
