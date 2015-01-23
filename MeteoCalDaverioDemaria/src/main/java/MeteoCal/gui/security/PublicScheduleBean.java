/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.gui.security;

import MeteoCal.business.security.boundary.EventManagerInterface;
import MeteoCal.business.security.boundary.UserManagerInterface;
import MeteoCal.business.security.entity.Event;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleModel;

/**
 *
 * @author Matteo
 */
@ViewScoped
@Named
public class PublicScheduleBean implements Serializable {
    
    @EJB
    EventManagerInterface em;
    @EJB
    UserManagerInterface um;
    
    private List<String> users = new ArrayList<>();
    private Event event;

    private ScheduleModel eventModel;

    private String username;
    
    /**
     * initialize public calendar
     */
    @PostConstruct
    public void init() {
        eventModel = new DefaultScheduleModel();
        users = um.getListUsersPublic();
    }
    
    /**
     * load event of public calendar
     */
    public void loadCalendar() {

        List<Event> tempCalendar = em.loadPublicCalendar(username);
        for (Event tempEvent : tempCalendar) {
            DefaultScheduleEvent temp = new DefaultScheduleEvent(tempEvent.getTitle(), tempEvent.getStartTime(), tempEvent.getEndTime());
            temp.setDescription(tempEvent.getIdEvent().toString());
            if (!eventModel.getEvents().contains(temp)) {
                eventModel.addEvent(temp);
            } else {
                eventModel.updateEvent(temp);
            }

        }

    }
    
    
    /**
     * getter e setter
     * @return
     */
    public ScheduleModel getEventModel() {
        return eventModel;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<String> getUsers() {
        return users;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public void setUsers(List<String> users) {
        this.users = users;
    }
    
}
