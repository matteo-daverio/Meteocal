/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.business.security.boundary;

import MeteoCal.business.security.entity.Event;
import MeteoCal.business.security.entity.Notification;
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
    
        /**
     * add Event and place if not already saved ,
     *
     * @param event Event to Add
     * @param user Creator
 
 * 
     */

    public void addEvent(Event event) {

            em.merge(event.getPlace());
            em.persist(event.getIdEvent());
            em.persist(event);
        }

    

    public boolean isCreator(Event event, Users user) {
        Query query = em.createQuery("SELECT n FROM Notification n WHERE n.event= :event and n.user= :user").setParameter("event", event).setParameter("user", user);
        List<Notification> result = new ArrayList<>(query.getResultList());
        return result.get(0).isCreator();
    }


    /**
     * remove event and related UserEvent
     *
     * @param event
     */

    public void removeEvent(Event event) {


        Query query2 = em.createQuery("Delete From Notification n Where n.event= :event").setParameter(("event"), event);
        query2.executeUpdate();
        Query query3 = em.createQuery("Delete From Event e Where e.idEvent= :event").setParameter(("event"), event.getIdEvent());
        query3.executeUpdate();

    }


    
        /**
     * return Invitations of User
     *
     * @param user
     * @return
     */
  
    public List<Event> findInvitatedEvent(Users user) {

        Query query = em.createQuery("SELECT n.event FROM Notification n WHERE n.user = :user AND n.creator=false and n.view=false").setParameter(("user"), user);
        List<Event> tempSet = new ArrayList<>(query.getResultList());

        return (List) tempSet;
    }

        /**
     * return User Events ( Created or Accepted)
     *
     * @param user
     * @return
     */

    public List<Event> loadCalendar(Users user) {

        Query query = em.createQuery("SELECT n.event FROM Notification n WHERE (n.user = :user AND (n.accepted=true OR n.creator=true))").setParameter(("user"), user);
        List<Event> tempSet = new ArrayList<>(query.getResultList());

        return tempSet;
    }

    
        /**
     * load Public calendar of the User
     *
     * @param username
     * @return
     */

    public List<Event> loadPublicCalendar(String username) {

        Query query = em.createQuery("SELECT n.event FROM Notification n WHERE (n.user.mail = :user AND (n.accepted=true OR n.creator=true) AND n.event.isPublic=true)").setParameter(("user"), username);
        List<Event> tempSet = new ArrayList<>(query.getResultList());

        return tempSet;
    }

    
    
        /**
     * return events created by User
     *
     * @param user
     * @return
     */
   
    public List<Event> getEventsCreated(Users user) {

        Query query = em.createQuery("Select e From Event e Where e.creator.mail= :mail").setParameter("mail", user.getMail());
        return query.getResultList();
    }


    /**
     * return true if event is indoor
     *
     * @param event
     * @return
     */

    public boolean isIndoor(Event event) {
        Query query = em.createQuery("SELECT e FROM Event e WHERE e= :event").setParameter("event", event);
        List<Event> result = new ArrayList<>(query.getResultList());
        return !result.get(0).getIsOutdoor();
    }


   
    public boolean eventIsPublic(Event event){
    
        Query query=em.createQuery("SELECT e FROM event e WHERE e =:event").setParameter("event", event);
        List<Event> result= new ArrayList<>(query.getResultList());
        return result.get(0).getIsPublic();
        
    }
    
}
