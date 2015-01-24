/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.gui.security;

import MeteoCal.business.security.EventCreator;
import MeteoCal.business.security.boundary.EventManagerInterface;
import MeteoCal.business.security.boundary.IDEventManagerInterface;
import MeteoCal.business.security.boundary.NotificationManagerInterface;
import MeteoCal.business.security.boundary.OwmClientInterface;
import MeteoCal.business.security.boundary.UserManagerInterface;
import MeteoCal.business.security.entity.Event;
import MeteoCal.business.security.entity.IDEvent;
import MeteoCal.business.security.entity.Notification;
import MeteoCal.exception.InvalidDateException;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.primefaces.context.RequestContext;
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
    RequestContext r;
    
    @EJB
    private EventManagerInterface em;
    @EJB
    private UserManagerInterface um;
    @EJB
    private NotificationManagerInterface nm;
    @EJB
    private IDEventManagerInterface idm;
    @EJB
    private OwmClientInterface weather;
    
    
    //Utility Date to convert timestamps
    private Date startDate = new Date();
    private Date endDate = new Date();
    
    /**
     * List of users selected by creator user
     */
    private List<String> selectedUsers = new ArrayList<>();
    private Notification notification;
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
        } catch (InvalidDateException e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Warning!", "Date not correct"));
        }
        eventCreated = new EventCreator();

    }
    
    public void unload() {
        this.required = false;
    }

    public void reCreate() throws InvalidDateException {
        FacesContext context = FacesContext.getCurrentInstance();

        this.addEvent();
        this.addUserEvent();
        context.addMessage(null, new FacesMessage("Successful", "Event Recreated"));

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
    
    /**
     * Username of user to load in Event Dialog
     *
     * @return List of Users
     */
    public List<String> listUser() {
        return um.getListUsers();
    }
    
    private void addEvent() throws InvalidDateException {

        if (this.controlDate()) {
            IDEvent idEv = new IDEvent(idm.findFirstFreeID());
            eventCreated.setIdEvent(idEv);
            eventCreated.setCreator(um.getLoggedUser());
            Event event = new Event();

            event.loadEvent(eventCreated);

            em.addEvent(event);
            weather.push(event.getPlace());
        } else {
            throw new InvalidDateException();
        }
    }
    
    
    
    private void addUserEvent() {
        Event event = new Event();
        event.loadEvent(eventCreated);
        notification = new Notification(event, um.getLoggedUser(), true);
        nm.addNotification(notification);
        for (String invitated1 : selectedUsers) {
            notification = new Notification(event, um.findByMail(invitated1), false);
            nm.addNotification(notification);
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
    
    public void createFromModify() throws InvalidDateException {
        FacesContext context = FacesContext.getCurrentInstance();
        if (context == null) {
            context = c;
        }

        this.addEvent();
        this.addUserEvent();
        context.addMessage(null, new FacesMessage("Successful", "Event Modifed"));

        eventCreated = new EventCreator();
    }
    
    
    /**
     * Function that modify ( and all consequent invitations )
     * the event selected in database using fields modified by user
     */
    public void modify() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (context == null) {
            context = c;
        }
        try {
            this.updateEvent();
        } catch (InvalidDateException e) {
            eventCreated = temporaryEvent;
            this.setStartDate(temporaryEvent.getStartDate());
            this.setEndDate(temporaryEvent.getEndDate());
            try {
                this.reCreate();
            } catch (InvalidDateException ex) {
                Logger.getLogger(EventBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", e.getMessage()));
        }
        RequestContext request = RequestContext.getCurrentInstance();
        if (request == null) {
            request = r;
        }
        request.update("homePage:schedule");
        this.resetBean();

    }
    
    /**
     * Function that cancel ( and all consequent invitations)
     * the event selected in database using fields modified by user
     */
    public void cancel() {
        FacesContext context = FacesContext.getCurrentInstance();
        if (context == null) {
            context = c;
        }
        Event event = new Event();
        event.loadEvent(eventCreated);
        em.removeEvent(event);
        RequestContext request = RequestContext.getCurrentInstance();
        if (request == null) {
            request = r;
        }
        request.update("homePage:schedule");
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "Event delete completed"));
    }
    
    /**
     * After accepting an invitation , The function revert decision of the user
     * for the selected event
     *
     * @return String for redirecting page
     */
    public String decline() {
        Event event = new Event();
        event.loadEvent(eventCreated);

        Notification ue=nm.getNotificationofUser(event, um.getLoggedUser());
        nm.modifyNotification(ue, false, false);
        return "home?faces-redirect=true";
    }
    
    /**
     * Function that called by the warning dialog change the Event date in case
     * of warning for weather condition
     *
     * @param event the @Event to change
     * @param userEvent @Event invitations
     * @throws InvalidDateException
     */
    public void modifyFromWarning(Event event, List<String> userEvent) throws InvalidDateException {
        em.removeEvent(event);
        this.resetBean();
        this.selectedUsers = userEvent;
        this.eventCreated.loadEvent(event);
        this.startDate = eventCreated.getStartDate();
        this.endDate = eventCreated.getStartDate();
        this.addEvent();
        this.addUserEvent();
        this.resetBean();
    }
    
    private void loadInvitations() {
        Event event = new Event();
        event.loadEvent(eventCreated);
        List<String> invitedUsers = nm.invitedUsersOfEvent(event);
        for (String invitedUser : invitedUsers) {
            this.selectedUsers.add(invitedUser);
        }
    }
    
    private boolean controlDate() {
        Timestamp now = new Timestamp(new java.util.Date().getTime());
        this.eventCreated.convertStartDate(startDate);
        this.eventCreated.convertEndDate(endDate);
        boolean correct;
        //date must be after today and start must be before end date
        correct = !(eventCreated.getStartDate().after(eventCreated.getEndDate()) || 
                eventCreated.getStartDate().before(now));
        return correct;
    }

    public boolean isCanDecline() {
        return !this.isOwnEvent & !this.creating;
    }

    private void updateEvent() throws InvalidDateException {
        Event oldEvent = em.loadSpecificEvent(eventCreated.getIdEvent().getId().toString());
        temporaryEvent.loadEvent(oldEvent);
        Event event = new Event();
        event.loadEvent(eventCreated);
        em.removeEvent(event);
        this.createFromModify();
    }
    
    
    /**
     * getter and setter
     * @return 
     */    
    public boolean isCanSelectPreferences() {
        return this.eventCreated.isOutdoor() & this.isOwnEvent;
    }

    public boolean isIsOwnEvent() {
        return isOwnEvent;
    }

    public boolean canEliminate() {
        return this.isOwnEvent & !this.creating;
    }

    public void setIsOwnEvent(boolean isOwnEvent) {
        this.isOwnEvent = isOwnEvent;
    }

    public boolean isCanEliminate() {
        return this.isOwnEvent & !this.creating;
    }

    public boolean isCreating() {
        return creating;
    }

    public void setCreating(boolean creating) {
        this.creating = creating;
    }

    public EventCreator getBeanEvent() {
        if (eventCreated == null) {
            eventCreated = new EventCreator();
        }
        return eventCreated;
    }

    public void setBeanEvent(EventCreator eventCreated) {
        this.eventCreated = eventCreated;
    }

    public List<String> getToInviteUsers() {
        return selectedUsers;
    }

    public void setToInviteUsers(List<String> toInviteUsers) {
        this.selectedUsers = toInviteUsers;
    }


    public EventManagerInterface getEm() {
        return em;
    }

    public void setEm(EventManagerInterface em) {
        this.em = em;
    }

    public NotificationManagerInterface getUem() {
        return nm;
    }

    public void setUem(NotificationManagerInterface nm) {
        this.nm = nm;
    }

    public UserManagerInterface getUm() {
        return um;
    }

    public void setUm(UserManagerInterface um) {
        this.um = um;
    }

    public List<String> getSelectedUsers() {
        return selectedUsers;
    }

    public void setSelectedUsers(List<String> selectedUsers) {
        this.selectedUsers = selectedUsers;
    }

    public Notification getUserEvent() {
        return notification;
    }

    public void setUserEvent(Notification notification) {
        this.notification = notification;
    }

    public EventCreator getTempEvent() {
        return eventCreated;
    }

    public void setTempEvent(EventCreator eventCreated) {
        this.eventCreated = eventCreated;
    }

    public FacesContext getContext() {
        return c;
    }

    public void setContext(FacesContext context) {
        this.c = context;
    }

    public OwmClientInterface getWeather() {
        return weather;
    }

    public void setWeather(OwmClientInterface weather) {
        this.weather = weather;
    }

    public FacesContext getC() {
        return c;
    }

    public void setC(FacesContext c) {
        this.c = c;
    }

    public RequestContext getR() {
        return r;
    }

    public void setR(RequestContext r) {
        this.r = r;
    }
    
     public IDEventManagerInterface getIdm() {
        return idm;
    }

    public void setIdm(IDEventManagerInterface idm) {
        this.idm = idm;
    }
    
    
    
    
}
