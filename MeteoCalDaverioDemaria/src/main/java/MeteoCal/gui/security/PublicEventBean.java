/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.gui.security;

import MeteoCal.business.security.boundary.EventManager;
import MeteoCal.business.security.boundary.NotificationManagerInterface;
import MeteoCal.business.security.boundary.UserManager;
import MeteoCal.business.security.entity.Event;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;

/**
 *
 * @author Matteo
 */
@Named
@RequestScoped
public class PublicEventBean {
    
    
    @EJB
    private EventManager em;
    @EJB
    private NotificationManagerInterface nm;
    @EJB
    private UserManager um;
    
    
    /**
     * Invitated Users of public Event
     */
    private List<String> invitated = new ArrayList<>();
    /**
     * Seleted Public Event
     */
    private Event event;
    
    
        
    
    
    @PostConstruct
    public void init() {
        event = new Event();
    }
    
    /**
     * Called by primeface schedule's if click on a public event
     *
     * @param selectEvent
     */
    public void onEventSelect(SelectEvent selectEvent) {
        DefaultScheduleEvent selectedEvent = (DefaultScheduleEvent) selectEvent.getObject();
        event = em.loadSpecificEvent(selectedEvent.getDescription());
        List<String> invitedUsers = nm.invitedUsersOfEvent(event);
        for (String invitedUser : invitedUsers) {
            this.invitated.add(invitedUser);
        }

    }
    
    /*
    * getter e setter
    */
    public String getPublicEvent() {
        if (event.isPublic()) {
            return "public";
        } else {
            return "private";
        }
    }

    public String getOutdoor() {
        if (event.isOutdoor()) {
            return "outdoor";
        } else {
            return "indoor";
        }

    }

    public Date getStartDate() {
        if (event.getStartTime() != null) {
            Date temp = new Date(event.getStartTime().getTime());
            return temp;
        } else {
            return null;
        }
    }

    public Date getEndDate() {
        if (event.getStartTime() != null) {
            Date temp = new Date(event.getEndTime().getTime());
            return temp;
        } else {
            return null;
        }
    }

    public Event getEvent() {
        if (event == null) {
            event = new Event();
        }

        return event;
    }

    public List<String> getInvitated() {
        return invitated;
    }

    public void setInvitated(List<String> invitated) {
        this.invitated = invitated;
    }
    
    
    
}
