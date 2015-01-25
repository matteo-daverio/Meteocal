/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.business.security.boundary;


import MeteoCal.business.security.control.PasswordEncrypter;
import MeteoCal.business.security.entity.Users;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import static org.hamcrest.CoreMatchers.*;

/**
 *
 * @author DeMaria
 */

@RunWith(Arquillian.class)
public class UserManagerIT {
    
        

    @EJB
    UserManager cut;
    
    @PersistenceContext
    EntityManager em;
    
//    @PersistenceContext
//    EntityManager em;

    @Deployment
    public static WebArchive createArchiveAndDeploy() {
        return ShrinkWrap.create(WebArchive.class)
                .addClass(UserManager.class)
                .addPackage(Users.class.getPackage())
                .addAsResource("test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
    }
   
    @Test
    public void UserManagerShouldBeInjected() {
        assertNotNull(cut);
    }
    
    @Test
    public void EntityManagerShouldBeInjected() {
        assertNotNull(em);
    }

    @Test
    public void newUsersShouldBeValid() {
        Users newUser = new Users();
        newUser.setMail("invalidemail");
        try {
            cut.save(newUser);
        } catch (Exception e) {
            assertTrue(e.getCause() instanceof ConstraintViolationException);
        }
        assertNull(em.find(Users.class, "invalidemail"));
    }
    
    @Test
    public void passwordsShouldBeEncryptedOnDB() {
        Users newUser = new Users();
        String email = "valerio@polimi.com";
        String password = "password";
        newUser.setMail(email);
        newUser.setName("Valerio");
        newUser.setPsw(password);
        try {
            cut.save(newUser);
        } catch (Exception ex) {
            Logger.getLogger(UserManagerIT.class.getName()).log(Level.SEVERE, null, ex);
        }
        Users foundUser = em.find(Users.class, email);
        assertNotNull(foundUser);
        assertThat(foundUser.getPsw(),is(PasswordEncrypter.encryptPassword(password)));
    }
    
}
