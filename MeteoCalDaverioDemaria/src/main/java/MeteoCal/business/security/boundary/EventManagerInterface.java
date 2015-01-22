/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.business.security.boundary;

import MeteoCal.business.security.entity.Event;
import MeteoCal.business.security.entity.Users;
import java.util.List;
import javax.ejb.Remote;
import javax.persistence.EntityManager;

/**
 *
 * @author DeMaria
 */
@Remote
public interface EventManagerInterface {
    
    public void removeEvent(Event event);

    public void removeEventByID(Event event);

    public Event loadSpecificEvent(String idEvent);

    public boolean isIndoor(Event event);

    public void addEvent(Event event);

    public List<Event> findInvitatedEvent(Users user);

    public List<Event> loadCalendar(Users user);

    public List<Event> loadPublicCalendar(String username);

    public void removeAllEvent(Users user);

    public List<Event> getEventsCreated(Users user);

    public boolean isCreator(Event event, Users user);

    public EntityManager getEm();

    public void setEm(EntityManager em);

}
