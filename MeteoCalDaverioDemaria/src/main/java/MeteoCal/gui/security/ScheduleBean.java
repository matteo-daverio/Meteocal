/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.gui.security;

import MeteoCal.business.security.boundary.EventManager;
import MeteoCal.business.security.boundary.UserManager;
import MeteoCal.business.security.entity.Event;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleModel;

/**
 *
 * @author Matteo
 */
@ViewScoped
@Stateful
@Named("scheduleBean")
public class ScheduleBean implements Serializable {
    
    
    private ScheduleModel model;
    @EJB
    private EventManager em;
    @EJB
    private UserManager um;
    
    
    
    @PostConstruct
    public void init() {
        model = new DefaultScheduleModel();
        loadCalendar();
    }
    
    public ScheduleModel getModel(){
        return model;
    }

    private void loadCalendar() {
        List<Event> Calendar = em.loadCalendar(um.getLoggedUser());
        model = new DefaultScheduleModel();
        for (Event event : Calendar) {
            //Create a temporary event
            DefaultScheduleEvent temp;
            String weather;    // Stringa che indica il clima
            weather = this.getWeather(event);  
            temp = new DefaultScheduleEvent(event.getTitle(), event.getStartTime(), 
                    event.getEndTime(),weather);
            temp.setDescription(event.getIdEvent().toString());

            boolean repeated = false;
            for (int i = 0; i < model.getEventCount(); i++) {
                if (model.getEvents().get(i).getDescription().equals(temp.getDescription())) {
                    repeated = true;
                }

            }
            if (!repeated) {
                model.addEvent(temp);
            } else {
                model.updateEvent(temp);
            }
        }
    }

    
    
    private String getWeather(Event event) {
        String weather="";
        
        
        
        return weather;
    }
    
    
}
