/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.business.security.entity;

import MeteoCal.business.security.EventCreator;
import java.sql.Timestamp;
import java.util.Date;
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
public class EventTest {
    
    public EventTest() {
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
     * Test of getIdEvent method, of class Event.
     */
    @Test
    public void testGetIdEvent() {
        System.out.println("getIdEvent");
        Event instance = new Event();
        IDEvent expResult = null;
        IDEvent result = instance.getIdEvent();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIdEvent method, of class Event.
     */
    @Test
    public void testSetIdEvent() {
        System.out.println("setIdEvent");
        IDEvent idEvent = null;
        Event instance = new Event();
        instance.setIdEvent(idEvent);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isPublic method, of class Event.
     */
    @Test
    public void testIsPublic() {
        System.out.println("isPublic");
        Event instance = new Event();
        Boolean expResult = null;
        Boolean result = instance.isPublic();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIsPublic method, of class Event.
     */
    @Test
    public void testSetIsPublic() {
        System.out.println("setIsPublic");
        Boolean isPublic = null;
        Event instance = new Event();
        instance.setIsPublic(isPublic);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlace method, of class Event.
     */
    @Test
    public void testGetPlace() {
        System.out.println("getPlace");
        Event instance = new Event();
        Place expResult = null;
        Place result = instance.getPlace();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPlace method, of class Event.
     */
    @Test
    public void testSetPlace() {
        System.out.println("setPlace");
        Place Place = null;
        Event instance = new Event();
        instance.setPlace(Place);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of isOutdoor method, of class Event.
     */
    @Test
    public void testIsOutdoor() {
        System.out.println("isOutdoor");
        Event instance = new Event();
        Boolean expResult = null;
        Boolean result = instance.isOutdoor();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setIsOutdoor method, of class Event.
     */
    @Test
    public void testSetIsOutdoor() {
        System.out.println("setIsOutdoor");
        Boolean isOutdoor = null;
        Event instance = new Event();
        instance.setIsOutdoor(isOutdoor);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getStartTime method, of class Event.
     */
    @Test
    public void testGetStartTime() {
        System.out.println("getStartTime");
        Event instance = new Event();
        Timestamp expResult = null;
        Timestamp result = instance.getStartTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setStartTime method, of class Event.
     */
    @Test
    public void testSetStartTime() {
        System.out.println("setStartTime");
        Timestamp startTime = null;
        Event instance = new Event();
        instance.setStartTime(startTime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEndTime method, of class Event.
     */
    @Test
    public void testGetEndTime() {
        System.out.println("getEndTime");
        Event instance = new Event();
        Timestamp expResult = null;
        Timestamp result = instance.getEndTime();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setEndTime method, of class Event.
     */
    @Test
    public void testSetEndTime() {
        System.out.println("setEndTime");
        Timestamp endTime = null;
        Event instance = new Event();
        instance.setEndTime(endTime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDate method, of class Event.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Event instance = new Event();
        Date expResult = null;
        Date result = instance.getDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDate method, of class Event.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        Date date = null;
        Event instance = new Event();
        instance.setDate(date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTitle method, of class Event.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        Event instance = new Event();
        String expResult = "";
        String result = instance.getTitle();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTitle method, of class Event.
     */
    @Test
    public void testSetTitle() {
        System.out.println("setTitle");
        String Title = "";
        Event instance = new Event();
        instance.setTitle(Title);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDescription method, of class Event.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Event instance = new Event();
        String expResult = "";
        String result = instance.getDescription();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDescription method, of class Event.
     */
    @Test
    public void testSetDescription() {
        System.out.println("setDescription");
        String description = "";
        Event instance = new Event();
        instance.setDescription(description);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCreator method, of class Event.
     */
    @Test
    public void testGetCreator() {
        System.out.println("getCreator");
        Event instance = new Event();
        Users expResult = null;
        Users result = instance.getCreator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCreator method, of class Event.
     */
    @Test
    public void testSetCreator() {
        System.out.println("setCreator");
        Users creator = null;
        Event instance = new Event();
        instance.setCreator(creator);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of convertStartDate method, of class Event.
     */
    @Test
    public void testConvertStartDate() {
        System.out.println("convertStartDate");
        Date date = null;
        Event instance = new Event();
        instance.convertStartDate(date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of convertEndDate method, of class Event.
     */
    @Test
    public void testConvertEndDate() {
        System.out.println("convertEndDate");
        Date date = null;
        Event instance = new Event();
        instance.convertEndDate(date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loadEvent method, of class Event.
     */
    @Test
    public void testLoadEvent() {
        System.out.println("loadEvent");
        EventCreator e = null;
        Event instance = new Event();
        instance.loadEvent(e);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Event.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Event instance = new Event();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
