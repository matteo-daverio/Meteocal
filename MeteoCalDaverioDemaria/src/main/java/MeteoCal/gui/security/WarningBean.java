/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.gui.security;

import MeteoCal.business.security.boundary.BadWeatherManagerInterface;
import MeteoCal.business.security.boundary.EventManagerInterface;
import MeteoCal.business.security.boundary.NotificationManagerInterface;
import MeteoCal.business.security.boundary.UserManagerInterface;
import MeteoCal.business.security.entity.Event;
import MeteoCal.business.security.entity.IDEvent;
import MeteoCal.exception.InvalidDateException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author DeMaria
 */
@Named
@RequestScoped
public class WarningBean {
        /*
     * ******************************************************************
     * EJB MANAGERS
     * ******************************************************************
     */
    @EJB
    BadWeatherManagerInterface bwnm;
    @EJB
    UserManagerInterface um;
    @EJB
    EventManagerInterface em;
    @EJB
    NotificationManagerInterface nm;


    /*
     *******************************************************************
     * FIELDS
     *******************************************************************
     */
    /**
     * list of events with forecast warning
     */
    private List<Event> warnings;
    /**
     * list of timestamps containing the solution(if available) for the events
     * with warning
     */
    private List<Timestamp> solutions;
    /**
     * variable used to manage the calendar
     */
    private boolean enableModify = false;

    /**
     * initializer
     */
    @PostConstruct
    public void init() {
        loadWarnings();
    }

    /*
     *******************************************************************
     PUBLIC FUNCTIONS
     *******************************************************************
     */
    /**
     * Funtion that search a solution for every event with warning
     */
//    public void searchSolution() {
//        solutions = bwnm.findSolution(warnings);
//    }

    /**
     * call the method findWarnings that returns a list of event with warning
     */
    public void loadWarnings() {
        warnings = new ArrayList<>();
        warnings = bwnm.findWarnings(um.getLoggedUser());
        //if (!warnings.isEmpty()) {
            //searchSolution();
          //  enableModify = true;
        //} else
        {
            enableModify = false;
            Event noWarning = new Event();
            noWarning.setTitle("No Warnings");
            noWarning.setIdEvent(new IDEvent("-1"));
            warnings.add(noWarning);
        }
    }

    
    
    public int countWarnings(){
        return this.warnings.size();
    }
    
    
    
    /**
     * modify the event setting as a start day the date suggested
     *
     * @param event
     * @param eb
     * @return
     * @throws InvalidDateException
     */
    public String modifyButton(Event event, EventBean eb) throws InvalidDateException {
        FacesContext context = FacesContext.getCurrentInstance();

        if (event.getIdEvent().getId() != -1) {
            /*long diff = event.getEndDate().getTime() - event.getStartDate().getTime();
             Timestamp help;*/
            boolean ok = false;
            for (int i = 0; i < warnings.size() && !ok; i++) {
                if (Objects.equals(warnings.get(i).getIdEvent().getId(), event.getIdEvent().getId())) {
                    if (solutions.get(i) != null) {
                        /*event.setStartDate(solutions.get(i));
                         help = new Timestamp(0);
                         help.setTime(solutions.get(i).getTime() + diff);
                         event.setEndDate(help);
                         eb.modifyFromWarning(event, preferenceEvent, userEvent);*/
                        modify(event, solutions.get(i), eb);
                        ok = true;
                        warnings.remove(i);
                    }
                }
            }
            return "home?faces-redirect=true";
        }
        {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Warning!", "No Event To Modify"));
        }

        return "";
    }

    /**
     * This function modifies a event setting a new start and a new end Date due
     * to bad weather warning.
     *
     * @param event
     * @param solut
     * @param eb
     * @throws InvalidDateException
     */
    public void modify(Event event, Timestamp solut, EventBean eb) throws  InvalidDateException {

        List<String> userEvent = nm.invitedUsersOfEvent(event);
        long diff = event.getEndTime().getTime() - event.getStartTime().getTime();
        Timestamp help;

        event.setStartTime(solut);
        help = new Timestamp(0);
        help.setTime(solut.getTime() + diff);
        event.setEndTime(help);
        eb.modifyFromWarning(event, userEvent);
    }

    /**
     *
     * @param id: it's the id of the event
     * @return a string that contains the suggested day
     */
    public String getDate(Long id) {
        if (id != -1) {
            for (int i = 0; i < warnings.size(); i++) {
                if (Objects.equals(warnings.get(i).getIdEvent().getId(), id)) {
                    if (solutions.get(i) != null) {
                        return solutions.get(i).toString();
                    }
                }
            }
            return "no possible postpone in the next 10 days";
        }
        return "";
    }

    /*
     * ******************************************************************
     * GETTERS AND SETTERS
     *******************************************************************
     */
    public List<Timestamp> getSolutions() {
        return solutions;
    }

    public void setSolutions(List<Timestamp> solutions) {
        this.solutions = solutions;
    }

    public List<Event> getWarnings() {
        loadWarnings();
        return warnings;
    }

    public void setWarnings(List<Event> warnings) {
        this.warnings = warnings;
    }

    public boolean isEnableModify() {
        return enableModify;
    }

    public void setEnableModify(boolean enableModify) {
        this.enableModify = enableModify;
    }

}
