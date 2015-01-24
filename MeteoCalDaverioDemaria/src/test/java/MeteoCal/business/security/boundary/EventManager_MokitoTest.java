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
public class EventManager_MokitoTest {
  
    private EventManager cut;
    
    @Before
    public void setUp() {
        cut= mock(EventManager.class);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void verificationAddRemoveEvent(){
        
        System.out.println("verificationAddRemoveEvent");
        
        Event e1 =new Event();
        Event e2 =new Event();
        
        cut.addEvent(e1);
        cut.removeEvent(e1);
        cut.addEvent(e2);
        cut.removeEventByID(e2);
        
        verify(cut).addEvent(e1);
        verify(cut).removeEvent(e1);
        verify(cut).addEvent(e2);
        verify(cut).removeEventByID(e2);
        
    }
    @Test 
    public void loadCalendar() throws Exception {
    
        System.out.println("loadCalendar");
        
        EventManager testClass = Mockito.mock(EventManager.class);
   
        NotificationManager nm = Mockito.mock(NotificationManager.class);
        
        UserManager um =Mockito.mock(UserManager.class);
        
        
        
        Users user = new Users();
        Event e =new Event();  
        Notification n =new Notification(e,user,true);
        
        um.save(user);
        testClass.addEvent(e);
        nm.addNotification(n);
        
        List<Event> someList =new ArrayList<Event>();
        
        Mockito.when(testClass.loadCalendar(user)).thenReturn(someList);
          
    }
    
    @Test 
    public void findInvitatedEvents() throws Exception {
    
        System.out.println("findInvitatedEvents");
        
        EventManager testClass = Mockito.mock(EventManager.class);
   
        NotificationManager nm = Mockito.mock(NotificationManager.class);
        
        UserManager um =Mockito.mock(UserManager.class);
        
        
        
        Users user1 = new Users();
        Users user2 = new Users();
        
        Event e =new Event();  
        
        Notification n1 =new Notification(e,user1,true); //creatore evento
        
        Notification n2 = new Notification(e,user2,false); //invito
        
        n2.setView(false);
        
        um.save(user1);
        um.save(user2);
        testClass.addEvent(e);
        nm.addNotification(n1);
        nm.addNotification(n2);
        
        List<Event> someList =new ArrayList<Event>();
        
        Mockito.when(testClass.findInvitatedEvent(user2)).thenReturn(someList);
          
    }
    
}
