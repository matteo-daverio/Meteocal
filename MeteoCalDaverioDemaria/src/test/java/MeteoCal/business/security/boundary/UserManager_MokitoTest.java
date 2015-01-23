/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.business.security.boundary;

import MeteoCal.business.security.entity.Group;
import MeteoCal.business.security.entity.Users;
import javax.persistence.EntityManager;
import static org.hamcrest.CoreMatchers.is;
import org.junit.After;
import static org.junit.Assert.assertThat;
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
        cut.em = mock(EntityManager.class);
    }
    
    @After
    public void tearDown() {
    }

//    @Test
//    public void newUsersShouldBelongToUserGroupAndSavedOnce() throws Exception {
//        Users newUser = new Users();
//        cut.save(newUser);
//        assertThat(newUser.getGroupName(), is(Group.USERS));
//        verify(cut.em,times(1)).persist(newUser);
//    }  
}
