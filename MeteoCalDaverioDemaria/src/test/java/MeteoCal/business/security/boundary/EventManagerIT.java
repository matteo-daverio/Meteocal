/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.business.security.boundary;

import MeteoCal.business.security.entity.Event;
import MeteoCal.business.security.entity.Notification;
import MeteoCal.business.security.entity.Users;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.xml.registry.infomodel.User;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;
import org.junit.runner.RunWith;
/**
 *
 * @author DeMaria
 */
@RunWith(Arquillian.class) //tells JUnit to use Arquillian as the test controller
public class EventManagerIT {
  
    
    @EJB
    EventManager eventManager;
    @EJB 
    UserManager userManager;
    @EJB
    NotificationManager notificationManager;
    
    @PersistenceContext
    EntityManager em;
    
    //Arquillian then looks for a public static method annotated with the @Deployment annotation
    //to retrieve the test archive (i.e., micro-deployment).
    @Deployment
    public static JavaArchive createDeployment() {
        JavaArchive jar = ShrinkWrap.create(JavaArchive.class)
        
            .addClass(EventManager.class)
            .addPackage(Users.class.getPackage())
            .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
            .addAsManifestResource(EmptyAsset.INSTANCE, "EventTestbeans.xml"); //beans.xml is added in the META-INF directory to activate CDI in this archive.beans.xml in the META-INF directory to activate CDI in this archive.
        
        //to see the contents of the archive that ShrinkWrap creates when the test is run
        //System.out.println(jar.toString(true));
        
        return jar;
    }
    
    

    
    //inject the EventManager instance into a field directly above the test method
    //@Inject
    //EventManager eventManager;
    
     //Then some MAGIC(!!) happens and each @Test
    //method is run inside the container environment
    
    @Test
    public void EventManagerShouldBeInjected() {
        assertNotNull(eventManager);
    }
    
    @Test
    public void EntityManagerShouldBeInjected() {
        assertNotNull(em);
    }
    
    @Test
    public void should_addEvents(){
    
        Event e = new Event(); 
        
        eventManager.addEvent(e);
       
        Assert.assertNotNull(eventManager.loadSpecificEvent("compleanno"));
 
}
    
    @Test
    public void should_GetIndoor(){
    
        Event e = new Event();
        
        e.setOutdoor(false);
        
        eventManager.addEvent(e);
        
        Assert.assertEquals(eventManager.isIndoor(e), true);

}
    
    @Test
    public void should_removeEvents(){
    
        Event e = new Event();
       
        e.setDescription("compleanno");
        eventManager.addEvent(e);
        eventManager.removeEvent(e);
        
        Assert.assertNull(eventManager.loadSpecificEvent("compleanno"));
 
}
    @Test
    public void should_loadCalendar(){
    
        Event e1 = new Event();
        Event e2 = new Event();
        Users user = new Users();
        Notification n1 = new Notification(e1,user,true);
        Notification n2 = new Notification(e2,user,true);
       
        eventManager.addEvent(e1);
        eventManager.addEvent(e2);
        
        try {
            userManager.save(user);
        } catch (Exception ex) {
            Logger.getLogger(EventManagerIT.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        notificationManager.addNotification(n1);
        notificationManager.addNotification(n2);
        
        Assert.assertEquals(eventManager.loadCalendar(user).size(), 2);
       
 
}

    @Test
    public void should_getEventsCreated(){
    
        Event e1 = new Event();
        Event e2 = new Event();
        Users user = new Users();
        Notification n1 = new Notification(e1,user,true);
        Notification n2 = new Notification(e2,user,false);
       
        eventManager.addEvent(e1);
        eventManager.addEvent(e2);
        
        try {
            userManager.save(user);
        } catch (Exception ex) {
            Logger.getLogger(EventManagerIT.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        notificationManager.addNotification(n1);
        notificationManager.addNotification(n2);
        
        Assert.assertEquals(eventManager.getEventsCreated(user).size(), 1);
       
 
}
    
    @Test
    public void should_removeAllEvent(){
    
        Event e1 = new Event();
        Event e2 = new Event();
        Users user = new Users();
        Notification n1 = new Notification(e1,user,true);
        Notification n2 = new Notification(e2,user,true);
       
        eventManager.addEvent(e1);
        eventManager.addEvent(e2);
        
        try {
            userManager.save(user);
        } catch (Exception ex) {
            Logger.getLogger(EventManagerIT.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        notificationManager.addNotification(n1);
        notificationManager.addNotification(n2);

        eventManager.removeAllEvent(user);
        Assert.assertNull(eventManager.loadCalendar(user));
       
 
}
    
    @Test
    public void should_findInvitadedEvent(){
    
        Event e1 = new Event();
        Event e2 = new Event();
        Users user = new Users();
        Notification n1 = new Notification(e1,user,true);
        Notification n2 = new Notification(e2,user,false);
       
        eventManager.addEvent(e1);
        eventManager.addEvent(e2);
        
        try {
            userManager.save(user);
        } catch (Exception ex) {
            Logger.getLogger(EventManagerIT.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        notificationManager.addNotification(n1);
        notificationManager.addNotification(n2);
        
        Assert.assertEquals(eventManager.findInvitatedEvent(user).size(), 1);
       
 
}
    
}
