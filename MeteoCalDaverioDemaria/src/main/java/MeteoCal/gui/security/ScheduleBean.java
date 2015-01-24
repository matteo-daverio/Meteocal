/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.gui.security;

import MeteoCal.business.security.boundary.BadWeatherManagerInterface;
import MeteoCal.business.security.boundary.EventManagerInterface;
import MeteoCal.business.security.boundary.ForecastManagerInterface;
import MeteoCal.business.security.boundary.UserManagerInterface;
import MeteoCal.business.security.entity.Event;
import MeteoCal.business.security.entity.Forecast;
import java.io.Serializable;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateful;
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
@Stateful
@Named("scheduleBean")
public class ScheduleBean implements Serializable {
    
    
    private ScheduleModel model;
    @EJB
    private EventManagerInterface em;
    @EJB
    private UserManagerInterface um;
    @EJB
    private BadWeatherManagerInterface bwm;
    @EJB
    private ForecastManagerInterface fm;
    
    
    
    @PostConstruct
    public void init() {
        model = new DefaultScheduleModel();
        loadCalendar();
    }
    
    public ScheduleModel getModel(){
        return model;
    }

    public void loadCalendar() {
        List<Event> Calendar = em.loadCalendar(um.getLoggedUser());
        model = new DefaultScheduleModel();
        for (Event event : Calendar) {
            //Create a temporary event
            DefaultScheduleEvent temp;
            String weather;    // Stringa che indica il clima
            weather = this.getWeather(event);  
            temp = new DefaultScheduleEvent(event.getTitle(), event.getStartTime(), 
                    event.getEndTime(),weather);
            temp.setDescription(event.getIdEvent().getId().toString());

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
        
        List<Forecast> forecastEvent = fm.getForecastOfEvent(event);
        if (forecastEvent.isEmpty() || em.isIndoor(event)) {
            return "NoForecast";
        } else {

        }
        if (forecastEvent.size() > 1) {
            weather = weather + "Variable";
        } else {
            weather = weather + forecastEvent.get(0).getMainCondition().getCondition();
        }
        if (bwm.isWarned(event)) {
            weather = weather + "Warned";
        } else {
            weather = weather + "NotWarned";
        }
        
        return weather;
    }
    
    
}
