/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.gui.security;

import MeteoCal.business.security.EventCreator;
import MeteoCal.business.security.boundary.EventManager;
import MeteoCal.business.security.boundary.UserManager;
import MeteoCal.business.security.entity.Event;
import MeteoCal.exception.InvalidDateException;
import MeteoCal.exception.OverlappingException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;

/**
 *
 * @author Matteo
 */
@SessionScoped
@Named
public class EventBean implements Serializable {
    
    FacesContext c;
    
    @EJB
    private EventManager em;
    @EJB
    private UserManager um;
    
    
    //Utility Date to convert timestamps
    private Date startDate = new Date();
    private Date endDate = new Date();
    
    /**
     * List of users selected by creator user
     */
    private List<String> selectedUsers = new ArrayList<>();
    private UserEvent userEvent;
    private EventCreator eventCreated = new EventCreator();
    
    //booleans used to enable/disable buttons in dialog
    private boolean isOwnEvent;
    private boolean creating;
    private boolean required = true;
    
    private EventCreator temporaryEvent;
    
    // this function create an event, save it in the db 
    public void create() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (context == null) {
            context = c;
        }
        try {
            this.addEvent();
            this.addUserEvent();
            context.addMessage(null, new FacesMessage("Successful", "Event Created"));
        } catch (OverlappingException e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", e.getMessage()));
        } catch (InvalidDateException e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Warning!", "Date not correct"));
        }
        eventCreated = new EventCreator();

    }
    
    
    
    // load information about an event
    public void onEventSelect(SelectEvent selectEvent) {
        this.resetBean();
        DefaultScheduleEvent selectedEvent = (DefaultScheduleEvent) selectEvent.getObject();
        loadFromEventSelect(selectedEvent);
    }
    
    public void loadFromEventSelect(DefaultScheduleEvent selectedEvent) {

        Event event = em.loadSpecificEvent(selectedEvent.getDescription());
        eventCreated.loadEvent(event);
        this.isOwnEvent = em.isCreator(event, um.getLoggedUser());
        this.creating = false;
        eventCreated.getIdEvent().setId(Long.parseLong(selectedEvent.getDescription()));
        this.startDate = selectedEvent.getStartDate();
        this.endDate = selectedEvent.getEndDate();
        this.loadInvitations();
        this.loadPreferences();
    }

    
    // called in case of selection of a day
    public void onDateSelect(SelectEvent selectEvent) {

        DefaultScheduleEvent selectedEvent = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
        this.loadFromDateSelect(selectedEvent);
    }
    
    public void loadFromDateSelect(DefaultScheduleEvent selectedEvent) {
        this.resetBean();
        creating = true;
        isOwnEvent = true;
        Date correction;
        correction = new Date(selectedEvent.getStartDate().getTime() + (60 * 60000));
        this.setStartDate(correction);
        this.setEndDate(correction);
    }
    
    private void addEvent() throws OverlappingException, InvalidDateException {

        if (this.controlDate()) {
            IDEvent idEv = new IDEvent(idm.findFirstFreeID());
            eventCreated.setIdEvent(idEv);
            eventCreated.setCreator(um.getLoggedUser());
            Event event = new Event();

            event.loadEvent(beanEvent);

            em.addEvent(event, um.getLoggedUser());
            weather.push(event.getPlace());
        } else {
            throw new InvalidDateException();
        }
    }
    
    
    
    private void addUserEvent() {
        Event event = new Event();
        event.loadEvent(eventCreated);
        userEvent = new UserEvent(event, um.getLoggedUser(), true);
        uem.addUserEvent(userEvent);
        for (String invitated1 : selectedUsers) {
            userEvent = new UserEvent(event, um.findByMail(invitated1), false);
            uem.addUserEvent(userEvent);
            mailSender.sendMail(invitated1, "Invitation", userEvent.getEvent().toString());
        }
    }
    
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
    public boolean isRequired() {
        return required;
    }

    public void setRequired(boolean required) {
        this.required = required;
    }
    
    public void resetBean() {
        eventCreated = new EventCreator();
        selectedUsers = new ArrayList<>();
        temporaryEvent = new EventCreator();
        required = true;
    }
    
}
