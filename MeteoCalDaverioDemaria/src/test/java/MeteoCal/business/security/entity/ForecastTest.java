/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.business.security.entity;

import java.sql.Timestamp;
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
public class ForecastTest {
    
    public ForecastTest() {
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
     * Test of getId method, of class Forecast.
     */
    @Test
    public void testGetId() {
        System.out.println("getId");
        Forecast instance = new Forecast();
        int expResult = 0;
        int result = instance.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class Forecast.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        int id = 0;
        Forecast instance = new Forecast();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlace method, of class Forecast.
     */
    @Test
    public void testGetPlace() {
        System.out.println("getPlace");
        Forecast instance = new Forecast();
        Place expResult = null;
        Place result = instance.getPlace();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setPlace method, of class Forecast.
     */
    @Test
    public void testSetPlace() {
        System.out.println("setPlace");
        Place place = null;
        Forecast instance = new Forecast();
        instance.setPlace(place);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getMainCondition method, of class Forecast.
     */
    @Test
    public void testGetMainCondition() {
        System.out.println("getMainCondition");
        Forecast instance = new Forecast();
        MainCondition expResult = null;
        MainCondition result = instance.getMainCondition();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Forecast.
     */
    @Test
    public void testToString() {
        System.out.println("toString");
        Forecast instance = new Forecast();
        String expResult = "";
        String result = instance.toString();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setMainCondition method, of class Forecast.
     */
    @Test
    public void testSetMainCondition() {
        System.out.println("setMainCondition");
        MainCondition mainCondition = null;
        Forecast instance = new Forecast();
        instance.setMainCondition(mainCondition);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getDate method, of class Forecast.
     */
    @Test
    public void testGetDate() {
        System.out.println("getDate");
        Forecast instance = new Forecast();
        Timestamp expResult = null;
        Timestamp result = instance.getDate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDate method, of class Forecast.
     */
    @Test
    public void testSetDate() {
        System.out.println("setDate");
        Timestamp date = null;
        Forecast instance = new Forecast();
        instance.setDate(date);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of equals method, of class Forecast.
     */
    @Test
    public void testEquals() {
        System.out.println("equals");
        Object obj = null;
        Forecast instance = new Forecast();
        boolean expResult = false;
        boolean result = instance.equals(obj);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hashCode method, of class Forecast.
     */
    @Test
    public void testHashCode() {
        System.out.println("hashCode");
        Forecast instance = new Forecast();
        int expResult = 0;
        int result = instance.hashCode();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
