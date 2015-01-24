/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.business.security.boundary;

import MeteoCal.business.security.entity.Group;
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
public class UserManager_MokitoTest {
      private UserManager cut;
    
    @Before
    public void setUp() {
        cut = new UserManager();
        cut.setEm(mock(EntityManager.class));
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void newUsersShouldSavedOnce(){
        Users newUser = new Users();
        
          try {
              cut.save(newUser);
          } catch (Exception ex) {
              Logger.getLogger(UserManager_MokitoTest.class.getName()).log(Level.SEVERE, null, ex);
          }
          
        //assertThat(newUser.getGroupName(),is(Group.USERS));
        verify(cut.getEm(),times(1)).persist(newUser);
    }  
}
