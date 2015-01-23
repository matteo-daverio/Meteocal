/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.business.security.boundary;

import MeteoCal.business.security.entity.Users;
import java.util.List;
import javax.ejb.embeddable.EJBContainer;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author DeMaria
 */
public class UserManagerTest {
    
    public UserManagerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getEm method, of class UserManager.
     */
    @Test
    public void testGetEm() throws Exception {
        System.out.println("getEm");
        UserManager instance = new UserManager();
        EntityManager expResult = null;
        EntityManager result = instance.getEm();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEm method, of class UserManager.
     */
    @Test
    public void testSetEm() throws Exception {
        System.out.println("setEm");
        EntityManager em = null;
        UserManager instance = new UserManager();
        instance.setEm(em);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListUsers method, of class UserManager.
     */
    @Test
    public void testGetListUsers() throws Exception {
        System.out.println("getListUsers");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UserManagerInterface instance = (UserManagerInterface)container.getContext().lookup("java:global/classes/UserManager");
        List<String> expResult = null;
        List<String> result = instance.getListUsers();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of findByMail method, of class UserManager.
     */
    @Test
    public void testFindByMail() throws Exception {
        System.out.println("findByMail");
        String mail = "";
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UserManagerInterface instance = (UserManagerInterface)container.getContext().lookup("java:global/classes/UserManager");
        Users expResult = null;
        Users result = instance.findByMail(mail);
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCalendar method, of class UserManager.
     */
    @Test
    public void testSetCalendar() throws Exception {
        System.out.println("setCalendar");
        boolean status = false;
        Users user = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UserManagerInterface instance = (UserManagerInterface)container.getContext().lookup("java:global/classes/UserManager");
        instance.setCalendar(status, user);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListUsersPublic method, of class UserManager.
     */
    @Test
    public void testGetListUsersPublic() throws Exception {
        System.out.println("getListUsersPublic");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UserManagerInterface instance = (UserManagerInterface)container.getContext().lookup("java:global/classes/UserManager");
        List<String> expResult = null;
        List<String> result = instance.getListUsersPublic();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of save method, of class UserManager.
     */
    @Test
    public void testSave() throws Exception {
        System.out.println("save");
        Users user = null;
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UserManagerInterface instance = (UserManagerInterface)container.getContext().lookup("java:global/classes/UserManager");
        instance.save(user);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of unregister method, of class UserManager.
     */
    @Test
    public void testUnregister() throws Exception {
        System.out.println("unregister");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UserManagerInterface instance = (UserManagerInterface)container.getContext().lookup("java:global/classes/UserManager");
        instance.unregister();
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getLoggedUser method, of class UserManager.
     */
    @Test
    public void testGetLoggedUser() throws Exception {
        System.out.println("getLoggedUser");
        EJBContainer container = javax.ejb.embeddable.EJBContainer.createEJBContainer();
        UserManagerInterface instance = (UserManagerInterface)container.getContext().lookup("java:global/classes/UserManager");
        Users expResult = null;
        Users result = instance.getLoggedUser();
        assertEquals(expResult, result);
        container.close();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
