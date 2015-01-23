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
public class IDEventTest {
    
    public IDEventTest() {
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
     * Test of getEvent method, of class IDEvent.
     */
    @Test
    public void testGetEvent() {
        System.out.println("getEvent");
        IDEvent instance = new IDEvent();
        Event expResult = null;
        Event result = instance.getEvent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEvent method, of class IDEvent.
     */
    @Test
    public void testSetEvent() {
        System.out.println("setEvent");
        Event event = null;
        IDEvent instance = new IDEvent();
        instance.setEvent(event);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getId method, of class IDEvent.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        IDEvent instance = new IDEvent();
        Long expResult = null;
        Long result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class IDEvent.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        Long id = null;
        IDEvent instance = new IDEvent();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class IDEvent.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        IDEvent instance = new IDEvent();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class IDEvent.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object object = null;
        IDEvent instance = new IDEvent();
        boolean expResult = false;
        boolean result = instance.equals(object);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class IDEvent.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        IDEvent instance = new IDEvent();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
