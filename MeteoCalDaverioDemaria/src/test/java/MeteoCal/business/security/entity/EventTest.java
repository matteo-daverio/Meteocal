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
     * Test of isPubblico method, of class Event.
     */
    @Test
    public void testIsPubblico() {
        System.out.println("isPubblico");
        Event instance = new Event();
        Boolean expResult = null;
        Boolean result = instance.isPubblico();
        assertEquals(expResult, result);

    }

    /**
     * Test of setPubblico method, of class Event.
     */
    @Test
    public void testSetPubblico() {
        System.out.println("setPubblico");
        Boolean pubblico = null;
        Event instance = new Event();
        instance.setPubblico(pubblico);

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

    }

    /**
     * Test of setOutdoor method, of class Event.
     */
    @Test
    public void testSetOutdoor() {
        System.out.println("setOutdoor");
        Boolean outdoor = null;
        Event instance = new Event();
        instance.setOutdoor(outdoor);

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

    }

    /**
     * Test of getTitle method, of class Event.
     */
    @Test
    public void testGetTitle() {
        System.out.println("getTitle");
        Event instance = new Event();
        String expResult = null;
        String result = instance.getTitle();
        assertEquals(expResult, result);

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

    }

    /**
     * Test of getDescription method, of class Event.
     */
    @Test
    public void testGetDescription() {
        System.out.println("getDescription");
        Event instance = new Event();
        String expResult = null;
        String result = instance.getDescription();
        assertEquals(expResult, result);

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

    }


    
}
