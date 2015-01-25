/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.business.security.boundary;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
/**
 *
 * @author DeMaria
 */
@RunWith(Arquillian.class) //tells JUnit to use Arquillian as the test controller
public class EventManagerIT {
  
    
    //Arquillian then looks for a public static method annotated with the @Deployment annotation
    //to retrieve the test archive (i.e., micro-deployment).
    @Deployment
    public static JavaArchive createDeployment() {
        JavaArchive jar = ShrinkWrap.create(JavaArchive.class)
        
            .addClass(EventManager.class)
            .addAsManifestResource(EmptyAsset.INSTANCE, "EventTestbeans.xml"); //beans.xml is added in the META-INF directory to activate CDI in this archive.beans.xml in the META-INF directory to activate CDI in this archive.
        
        //to see the contents of the archive that ShrinkWrap creates when the test is run
        //System.out.println(jar.toString(true));
        
        return jar;
    }
    
    
     //Then some MAGIC(!!) happens and each @Test
    //method is run inside the container environment
    
    
    
    @Test
    public void should_addEvents(){
    

}
    
}
