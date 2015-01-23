/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.business.security.entity;

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
public class NotificationTest {
    
    public NotificationTest() {
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
     * Test of getIdNotification method, of class Notification.
     */
    @Test
    public void testGetIdNotification() {
        System.out.println("getIdNotification");
        Notification instance = new Notification();
        Integer expResult = null;
        Integer result = instance.getIdNotification();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdNotification method, of class Notification.
     */
    @Test
    public void testSetIdNotification() {
        System.out.println("setIdNotification");
        Integer idNotification = null;
        Notification instance = new Notification();
        instance.setIdNotification(idNotification);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isCreator method, of class Notification.
     */
    @Test
    public void testIsCreator() {
        System.out.println("isCreator");
        Notification instance = new Notification();
        boolean expResult = false;
        boolean result = instance.isCreator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCreator method, of class Notification.
     */
    @Test
    public void testSetCreator() {
        System.out.println("setCreator");
        boolean creator = false;
        Notification instance = new Notification();
        instance.setCreator(creator);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isAccepted method, of class Notification.
     */
    @Test
    public void testIsAccepted() {
        System.out.println("isAccepted");
        Notification instance = new Notification();
        boolean expResult = false;
        boolean result = instance.isAccepted();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setAccepted method, of class Notification.
     */
    @Test
    public void testSetAccepted() {
        System.out.println("setAccepted");
        boolean accepted = false;
        Notification instance = new Notification();
        instance.setAccepted(accepted);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isView method, of class Notification.
     */
    @Test
    public void testIsView() {
        System.out.println("isView");
        Notification instance = new Notification();
        boolean expResult = false;
        boolean result = instance.isView();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setView method, of class Notification.
     */
    @Test
    public void testSetView() {
        System.out.println("setView");
        boolean view = false;
        Notification instance = new Notification();
        instance.setView(view);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEvent method, of class Notification.
     */
    @Test
    public void testGetEvent() {
        System.out.println("getEvent");
        Notification instance = new Notification();
        Event expResult = null;
        Event result = instance.getEvent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEvent method, of class Notification.
     */
    @Test
    public void testSetEvent() {
        System.out.println("setEvent");
        Event event = null;
        Notification instance = new Notification();
        instance.setEvent(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUser method, of class Notification.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        Notification instance = new Notification();
        Users expResult = null;
        Users result = instance.getUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUser method, of class Notification.
     */
    @Test
    public void testSetUser() {
        System.out.println("setUser");
        Users user = null;
        Notification instance = new Notification();
        instance.setUser(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Notification.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Notification instance = new Notification();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
