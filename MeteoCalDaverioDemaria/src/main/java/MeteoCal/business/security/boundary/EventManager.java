/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.business.security.boundary;

import MeteoCal.business.security.entity.Event;
import MeteoCal.business.security.entity.IDEvent;
import MeteoCal.business.security.entity.Notification;
import MeteoCal.business.security.entity.Users;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Remote;
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
@Remote(EventManagerInterface.class)
public class EventManager implements EventManagerInterface{
   
    @PersistenceContext
    private EntityManager em;
@Override
    public EntityManager getEm() {
        return em;
    }
@Override
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
 
 * 
     */
    @Override
    public void addEvent(Event event) {

            em.merge(event.getPlace());
            em.persist(event.getIdEvent());
            em.persist(event);
        }

    

    /**
     * remove all Event of an user for Importing
     *
     * @param user
     */
    @Override
    public void removeAllEvent(Users user) {
        System.out.println("Utente: " + user.getMail());
        Query query1 = em.createQuery("Delete From Preference p Where p.event in (Select e From Event e Where e.creator.mail = :mail)").setParameter(("mail"), user.getMail());
        query1.executeUpdate();
        Query query2 = em.createQuery("Delete From Notification n  Where n.event in (Select e From Event e Where e.creator.mail= :mail)").setParameter(("mail"), user.getMail());
        query2.executeUpdate();
        Query query3 = em.createQuery("Delete From Event e where e.creator.mail = :mail").setParameter(("mail"), user.getMail());
        query3.executeUpdate();
        System.out.println("Delete completed");
    }


    
        /**
     * return Event with iDEvent
     *
     * @param iDEvent
     * @return
     */
   @Override
    public Event loadSpecificEvent(String iDEvent) {
        IDEvent id = new IDEvent(Long.parseLong(iDEvent));
        Query query = em.createQuery("SELECT e FROM Event e WHERE e.idEvent =:id").setParameter("id", id);
        List<Event> result = new ArrayList<>(query.getResultList());

        return result.get(0);
    }

    
    @Override
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
    @Override
    public void removeEvent(Event event) {


        Query query2 = em.createQuery("Delete From Notification n Where n.event= :event").setParameter(("event"), event);
        query2.executeUpdate();
        Query query3 = em.createQuery("Delete From Event e Where e.getIdEvent.getId= :event").setParameter(("event"), event);
        query3.executeUpdate();

    }


    
        /**
     * return Invitations of User
     *
     * @param user
     * @return
     */
   @Override
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
@Override
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
@Override
    public List<Event> loadPublicCalendar(String username) {

        Query query = em.createQuery("SELECT n.event FROM Notification n WHERE (n.user.mail = :user AND (n.accepted=true OR n.creator=true) AND n.event.pubblico=true)").setParameter(("user"), username);
        List<Event> tempSet = new ArrayList<>(query.getResultList());

        return tempSet;
    }

    
    
        /**
     * return events created by User
     *
     * @param user
     * @return
     */
   @Override
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
@Override
    public boolean isIndoor(Event event) {
        Query query = em.createQuery("SELECT e FROM Event e WHERE e= :event").setParameter("event", event);
        List<Event> result = new ArrayList<>(query.getResultList());
        return !result.get(0).isOutdoor();
    }


   
    public boolean eventIsPublic(Event event){
    
        Query query=em.createQuery("SELECT e FROM event e WHERE e =:event").setParameter("event", event);
        List<Event> result= new ArrayList<>(query.getResultList());
        return result.get(0).isPubblico();
        
    }
    
        @Override
       public void removeEventByID(Event event) {
        Query query1 = em.createQuery("Delete From Preference p Where p.event.idEvent.id= :event").setParameter(("event"), event.getIdEvent().getId());
        query1.executeUpdate();
        Query query2 = em.createQuery("Delete From Notification n Where n.event.idEvent.id= :event").setParameter(("event"), event.getIdEvent().getId());
        query2.executeUpdate();
        Query query3 = em.createQuery("Delete From Event e Where e.idEvent.event.idEvent.id= :event").setParameter(("event"), event.getIdEvent().getId());
        query3.executeUpdate();
        Query query4 = em.createQuery("Delete From IDEvent e Where e.event.idEvent.id= :event").setParameter(("event"), event.getIdEvent().getId());
        query4.executeUpdate();
    }

    
}
