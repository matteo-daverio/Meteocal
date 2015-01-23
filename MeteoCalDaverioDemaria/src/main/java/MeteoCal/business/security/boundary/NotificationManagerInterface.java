/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.business.security.boundary;

import MeteoCal.business.security.entity.Event;
import MeteoCal.business.security.entity.Notification;
import MeteoCal.business.security.entity.Users;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author DeMaria
 */
@Remote
public interface NotificationManagerInterface {
    
    public void addNotification(Notification notification);

    public Users findEventCreator(Event event);

    public Notification getNotificationofUser(Event event, Users user);

    public void modifyNotification(Notification notification, boolean decision, boolean view);

    public List<String> invitedUsersOfEvent(Event event);

    public void deleteNotification(Event event);

    public List<Users> getUsersCreator();

    public List<Users> getInvitedWhoAccepted(Event event);
    
    public int counterNotification(Users user);

    
}
