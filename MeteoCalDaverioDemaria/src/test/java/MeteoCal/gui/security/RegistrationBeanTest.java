/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.gui.security;

import MeteoCal.business.security.entity.Users;
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
public class RegistrationBeanTest {
    
    public RegistrationBeanTest() {
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
     * Test of getUser method, of class RegistrationBean.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        RegistrationBean instance = new RegistrationBean();
        Users expResult = null;
        Users result = instance.getUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUser method, of class RegistrationBean.
     */
    @Test
    public void testSetUser() {
        System.out.println("setUser");
        Users user = null;
        RegistrationBean instance = new RegistrationBean();
        instance.setUser(user);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of register method, of class RegistrationBean.
     */
    @Test
    public void testRegister() {
        System.out.println("register");
        RegistrationBean instance = new RegistrationBean();
        String expResult = "";
        String result = instance.register();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
