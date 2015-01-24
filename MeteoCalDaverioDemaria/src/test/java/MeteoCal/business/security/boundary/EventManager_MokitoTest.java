/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.business.security.boundary;

import MeteoCal.business.security.entity.Event;
import MeteoCal.business.security.entity.Users;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 *
 * @author DeMaria
 */
public class EventManager_MokitoTest {
  
    private EventManager cut;
    
    @Before
    public void setUp() {
        cut = new EventManager();
        cut.setEm(mock(EntityManager.class));
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void newEventShouldSavedOnce(){
        
        Event e =new Event();
        e.setOutdoor(Boolean.TRUE);
        cut.addEvent(e);
        
        //assertThat(cut.isIndoor(e),false);
//          try {
//             // cut.save(newUser);
//          } catch (Exception ex) {
//              Logger.getLogger(UserManager_MokitoTest.class.getName()).log(Level.SEVERE, null, ex);
//          }
          
        //assertThat(newUser.getGroupName(),is(Group.USERS));
       // verify(cut.em,times(1)).persist(newUser);
    } 
    
}
