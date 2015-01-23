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
public class NotificationManager implements NotificationManagerInterface {
    
    @PersistenceContext
    private EntityManager em;

    @Inject
    Principal principal;

    /**
     * add a Notification
     * @param notification 
     */
    @Override
    public void addNotification(Notification notification) {
        em.merge(notification);
    }

    /**
     * searches who is the creator of an event
     *
     * @param event
     * @return the creator
     */
    @Override
    public Users findEventCreator(Event event) {
        Query query;
        query = em.createQuery("SELECT n.user From Notification n WHERE n.event= :event and n.creator=true").setParameter("event", event);
        List<Users> user = query.getResultList();
        return user.get(0);

    }
    
    @Override
     public int counterNotification(Users user){
         Query query;
         query=em.createQuery("SELECT count(n) FROM Notification n WHERE n.user= :user and n.view=0 and n.creator=0").setParameter("user", user);
         return ((Number)query.getSingleResult()).intValue();
     }

    /**
     * returns the tuple in Notification entity that match with the
     * passed parametes
     *
     * @param event
     * @param user
     * @return
     */
    @Override
    public Notification getNotificationofUser(Event event, Users user) {
        Query query;
        query = em.createQuery("SELECT n FROM Notification n WHERE n.event= :event and n.creator=0 and n.user = :user  ").setParameter("event", event).setParameter("user", user);
        List<Notification> result = query.getResultList();
        return result.get(0);
    }

    /**
     * this funtion modifies a tuple in Notification setting new values
     *
     * @param notification
     * @param decision
     * @param view
     */
    @Override
    public void modifyNotification(Notification notification, boolean decision, boolean view) {

        Query query = em
                .createQuery("UPDATE Notification n SET n.accepted = :decision , n.view = :view"
                        + " WHERE n= :notification");
        query.setParameter("notification", notification);
        query.setParameter("decision", decision);
        query.setParameter("view", view);
        query.executeUpdate();
    }

    /**
     * this function searches for invitation of an event
     *
     * @param event
     * @return a list of emails corresponding to invites
     */
    @Override
    public List<String> invitedUsersOfEvent(Event event) {
        Query query;
        query = em.createQuery("SELECT n.user.mail FROM Notification n WHERE n.event= :event and n.creator=0").setParameter("event", event);

        List<String> result = new ArrayList<>(query.getResultList());

        return result;
    }

    /**
     * this function deletes all tuples that have as event the passed parameter
     *
     * @param event
     */
    @Override
    public void deleteNotification(Event event) {
        Query query2 = em.createQuery("Delete From Notification n Where n.event= :event").setParameter(("event"), event);
        query2.executeUpdate();
    }

    /**
     *
     * @return all users that have created at least an event
     */
    @Override
    public List<Users> getUsersCreator() {

        Query query = em.createQuery("Select distinct n.user From Notification n Where n.creator=1");
        return query.getResultList();

    }

    /**
     *
     * @param event
     * @return a list of users that have accepted the invitation for the passed
     * event
     */
    @Override
    public List<Users> getInvitedWhoAccepted(Event event) {

        Query query = em.createQuery("Select n.user From Notification n Where n.event= :event and n.accepted=1").setParameter("event", event);
        return query.getResultList();

    }

    public EntityManager getEm() {
        return em;
    }

    public void setEm(EntityManager em) {
        this.em = em;
    }

    
}
