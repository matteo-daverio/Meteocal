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
public class UsersTest {
    
    public UsersTest() {
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
     * Test of getMail method, of class Users.
     */
    @Test
    public void testGetMail() {
        System.out.println("getMail");
        Users instance = new Users();
        String expResult = null;
        String result = instance.getMail();
        assertEquals(expResult, result);

    }

    /**
     * Test of setMail method, of class Users.
     */
    @Test
    public void testSetMail() {
        System.out.println("setMail");
        String mail = "";
        Users instance = new Users();
        instance.setMail(mail);

    }

    /**
     * Test of getName method, of class Users.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Users instance = new Users();
        String expResult = null;
        String result = instance.getName();
        assertEquals(expResult, result);

    }

    /**
     * Test of setName method, of class Users.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Users instance = new Users();
        instance.setName(name);

    }

    /**
     * Test of getPsw method, of class Users.
     */
    @Test
    public void testGetPsw() {
        System.out.println("getPsw");
        Users instance = new Users();
        String expResult = null;
        String result = instance.getPsw();
        assertEquals(expResult, result);

    }

    /**
     * Test of setPsw method, of class Users.
     */
    @Test
    public void testSetPsw() {
        System.out.println("setPsw");
        String psw = "";
        Users instance = new Users();
        instance.setPsw(psw);

    }

    /**
     * Test of setGroupName method, of class Users.
     */
    @Test
    public void testSetGroupName() {
        System.out.println("setGroupName");
        String groupName = "";
        Users instance = new Users();
        instance.setGroupName(groupName);

    }

    /**
     * Test of getGroupName method, of class Users.
     */
    @Test
    public void testGetGroupName() {
        System.out.println("getGroupName");
        Users instance = new Users();
        String expResult = null;
        String result = instance.getGroupName();
        assertEquals(expResult, result);

    }

    /**
     * Test of isPublicCalendar method, of class Users.
     */
    @Test
    public void testIsPublicCalendar() {
        System.out.println("isPublicCalendar");
        Users instance = new Users();
        boolean expResult = false;
        boolean result = instance.isPublicCalendar();
        assertEquals(expResult, result);

    }

    /**
     * Test of setPublicCalendar method, of class Users.
     */
    @Test
    public void testSetPublicCalendar() {
        System.out.println("setPublicCalendar");
        boolean publicCalendar = false;
        Users instance = new Users();
        instance.setPublicCalendar(publicCalendar);

    }

    
}
