/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.business.security.entity;

import java.util.List;
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
public class MainConditionTest {
    
    public MainConditionTest() {
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
     * Test of getCondition method, of class MainCondition.
     */
    @Test
    public void testGetCondition() {
        System.out.println("getCondition");
        MainCondition instance = new MainCondition();
        String expResult = "";
        String result = instance.getCondition();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setCondition method, of class MainCondition.
     */
    @Test
    public void testSetCondition() {
        System.out.println("setCondition");
        String Condition = "";
        MainCondition instance = new MainCondition();
        instance.setCondition(Condition);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getListPref method, of class MainCondition.
     */
    @Test
    public void testGetListPref() {
        System.out.println("getListPref");
        List<String> expResult = null;
        List<String> result = MainCondition.getListPref();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
