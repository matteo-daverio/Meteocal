/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.gui.security;

import MeteoCal.business.security.EventCreator;
import MeteoCal.business.security.boundary.EventManagerInterface;
import MeteoCal.business.security.boundary.NotificationManagerInterface;
import MeteoCal.business.security.boundary.UserManagerInterface;
import MeteoCal.business.security.entity.Event;
import MeteoCal.business.security.entity.Notification;
import MeteoCal.business.security.entity.Users;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Matteo
 */
@RequestScoped
@Named
public class InvitationBean implements Serializable {
    
    @EJB
    EventManagerInterface em;
    @EJB
    UserManagerInterface um;
    @EJB
    NotificationManagerInterface nm;
    
    /**
     * Event which user is invited
     */
    private List<EventCreator> invites;

    //boolean used for enable/disable buttons
    private boolean enableInvitation = false;
    
    
    
    
    /**
     * Initialization
     */
    @PostConstruct
    public void init() {
        invites = new ArrayList<>();
        loadInvites();
    }

    /**
     * query database and load Invitations
     */
    public void loadInvites() {
        List<Event> events = em.findInvitatedEvent(um.getLoggedUser());
        for (Event event : events) {
            EventCreator temp = new EventCreator();
            temp.loadEvent(event);
            invites.add(temp);
        }
        enableInvitation = true;
        if (invites.isEmpty()) {
            enableInvitation = false;
            EventCreator noInvitation = new EventCreator();
            noInvitation.setTitle("No Invitation");
            invites.add(noInvitation);
        }
    }

    public int loadNumberOfInvites(Users user){
      return nm.counterNotification(user);
    }
    
    /**
     * User Accept Invitation
     *
     * @param eventC
     * @return
     */
    public String acceptInvite(EventCreator eventC) {
        Event event = new Event();
        event.loadEvent(eventC);
        Notification notification = nm.getNotificationofUser(event, um.getLoggedUser());
        nm.modifyNotification(notification, true, true);
        invites.remove(eventC);
        return "home?faces-redirect=true";
    }

    /**
     * User Decline Invitation ( will be never seen )
     *
     * @param eventC
     * @return
     */
    public String declineInvite(EventCreator eventC) {
        Event event = new Event();
        event.loadEvent(eventC);
        Notification notification = nm.getNotificationofUser(event, um.getLoggedUser());
        nm.modifyNotification(notification, false, true);
        invites.remove(eventC);
        if (invites.isEmpty()) {
            enableInvitation = false;
            EventCreator noInvitation = new EventCreator();
            noInvitation.setTitle("No Invitation");
            invites.add(noInvitation);
        }
        return "home?faces-redirect=true";
    }
    
    
    
    /**
     * getter e setter
     * @return 
     */
    public boolean isEnableInvitation() {
        return enableInvitation;
    }

    public void setEnableInvitation(boolean enableInvitation) {
        this.enableInvitation = enableInvitation;
    }

    public List<EventCreator> getInvites() {
        return invites;
    }

    public void setInvites(List<EventCreator> invites) {
        this.invites = invites;
    }
    
}
