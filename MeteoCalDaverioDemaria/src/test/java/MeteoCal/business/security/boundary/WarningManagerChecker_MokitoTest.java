/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.business.security.boundary;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 *
 * @author DeMaria
 */


public class WarningManagerChecker_MokitoTest {
    
    private WarningManagerChecker cut;
    
    @Before
    public void setUp() {
        cut= mock(WarningManagerChecker.class);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void oneDayWarning(){
        
        System.out.println("oneDayWarning");
        
        cut.oneDayWarning();

        verify(cut).oneDayWarning();
        
    }
    
    @Test
    public void threeDaysWarning(){
        
        System.out.println("threeDaysWarning");
        
        cut.threeDaysWarning();

        verify(cut).threeDaysWarning();
        
    }
    
}
