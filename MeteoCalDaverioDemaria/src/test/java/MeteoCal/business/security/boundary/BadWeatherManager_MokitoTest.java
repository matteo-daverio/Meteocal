/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.business.security.boundary;

import MeteoCal.business.security.entity.Event;
import MeteoCal.business.security.entity.Forecast;
import MeteoCal.business.security.entity.MainCondition;
import MeteoCal.business.security.entity.Notification;
import MeteoCal.business.security.entity.Place;
import MeteoCal.business.security.entity.Users;
import java.util.ArrayList;
import static java.util.Calendar.DATE;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;

/**
 *
 * @author DeMaria
 */
public class BadWeatherManager_MokitoTest {
  
        //private EventManager cut;
        
        private final BadWeatherManager bwm = new BadWeatherManager();
        private final EventManager evMa = new EventManager();
        private final NotificationManager notMa = new NotificationManager();
        private final UserManager usMa = new UserManager();
    
    @Before
    public void setUp() {
        //cut= mock(EventManager.class);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void isWarned(){
        /*
        System.out.println("isWarned");
       
        System.out.println("1");
        
        MainCondition mc = new MainCondition();
        mc.setCondition("Clear");
        
        System.out.println("2");
        
        Forecast f = new Forecast();
        Event e = new Event();
       
        System.out.println("3");
        
        Users user = new Users();
        user.setMail("ciccio@mail.it");
        
        System.out.println("4");
        
        try {
            usMa.save(user);
        } catch (Exception ex) {
            Logger.getLogger(BadWeatherManager_MokitoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("5");
        
        e.setOutdoor(false);
       
        System.out.println("5,5");
        
        evMa.addEvent(e); //salvo l'evento del DB
        
        System.out.println("6");

        Notification n = new Notification(e,user,true);
        notMa.addNotification(n); //salvo notification nel DB
        
        
        System.out.println("7");
        
        f.setMainCondition(mc);
        evMa.getEm().persist(f); //salvo la forecast nel DB
        
        System.out.println("8");
        
        Assert.assertEquals(bwm.isWarned(e),false);
     */   
    }
    
    
    @Test 
    public void findWarnings() throws Exception {
    
        /*
        System.out.println("findWarnings");
        
        BadWeatherManager bwm =Mockito.mock(BadWeatherManager.class);      
        //ForecastManager fm = Mockito.mock(ForecastManager.class);
        EventManager evm = Mockito.mock(EventManager.class);
        NotificationManager nm = Mockito.mock(NotificationManager.class);
        UserManager um =Mockito.mock(UserManager.class);
        
        
        Place place = new Place();
        Users user = new Users();
        Event e =new Event();
        Forecast f = new Forecast();
        MainCondition main_condition = new MainCondition();
       
        //l'evento è creato dall'user
        Notification n =new Notification(e,user,true); 
        
         //l'evento è outdoor
        e.setOutdoor(true);
        
        //impongo che il luogo dell'evento sia uguale al posto della previsione
        e.setPlace(place);
        f.setPlace(place);
        
        //imposto una condizione tale da darmi un warning
        main_condition.setCondition("Rain");
        f.setMainCondition(main_condition);
        
        //la previsione è relativa al momento in cui si svolge l'evento
        f.setDate(e.getStartTime());
        
        //salvo la previsione meteo nel DB 
        evm.getEm().persist(f);
           
        //salvo l'utente nel DB
        um.save(user);
        
        //salvo l'evento nel DB
        evm.addEvent(e);
        
        //salvo la Notification nel DB
        nm.addNotification(n);
        
   
        
        List<Event> someList =new ArrayList<Event>();
        
        Mockito.when(bwm.findWarnings(user)).thenReturn(someList);
       */
        
        
    }
    
    
}
