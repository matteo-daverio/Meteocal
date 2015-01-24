/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.business.security.boundary;

import MeteoCal.business.security.entity.Event;
import MeteoCal.business.security.entity.Notification;
import MeteoCal.business.security.entity.Users;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 *
 * @author DeMaria
 */

public class NotificationManager_MokitoTest {
        
    private NotificationManager cut;
    private EventManager event_man;
    private UserManager user_man;
    
    @Before
    public void setUp() {
        cut= mock(NotificationManager.class);
        event_man= mock(EventManager.class);
        user_man = mock(UserManager.class);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void verificationAddRemoveNotification() throws Exception{
        
        
        System.out.println("verificationAddRemoveNotification");
        
        
        Event e = new Event();
        Users user = new Users();
        Notification n = new Notification(e,user,false);
       
        
        event_man.addEvent(e);
        user_man.save(user);
        
        cut.addNotification(n);
        cut.deleteNotification(e);

        
        verify(cut).addNotification(n);
        verify(cut).deleteNotification(e);
        
        
    }
    
    
    
    
//        @Test
//    public void verificationAddRemoveEvent(){
//        
//        System.out.println("verificationAddRemoveEvent");
//        
//        Event e1 =new Event();
//        Event e2 =new Event();
//        
//        cut.addEvent(e1);
//        cut.removeEvent(e1);
//        cut.addEvent(e2);
//        cut.removeEventByID(e2);
//        
//        verify(cut).addEvent(e1);
//        verify(cut).removeEvent(e1);
//        verify(cut).addEvent(e2);
//        verify(cut).removeEventByID(e2);
//        
//    }
    
    
    
    
    
    
    
    
    
    
   @Test
   public void invitedUsersOfEvent() throws Exception{
   
      
    System.out.println("invitedUsersOfEvent");
    
    NotificationManager testClass = Mockito.mock(NotificationManager.class);
    UserManager usMa = Mockito.mock(UserManager.class);
    EventManager evMa = Mockito.mock(EventManager.class);
    
    Event e = new Event();
    Users user = new Users();
    
    Notification n = new Notification(e,user,false);
    
    user.setMail("giacomo@mail.it");
    evMa.addEvent(e);
    usMa.save(user);
    testClass.addNotification(n);
   
    List<String> someList = new ArrayList<String>();
    
    Mockito.when(testClass.invitedUsersOfEvent(e)).thenReturn(someList);
             
 }

}
