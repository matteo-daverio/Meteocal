/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.business.security.boundary;

import MeteoCal.business.security.entity.Event;
import MeteoCal.business.security.entity.Forecast;
import MeteoCal.business.security.entity.MainCondition;
import MeteoCal.business.security.entity.Users;
import java.security.Principal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Matteo
 */

@Stateless
public class BadWeatherManager implements BadWeatherManagerInterface {
    
    @PersistenceContext
    private EntityManager em;

    @Inject
    Principal principal;

    @EJB
    private EventManagerInterface emi;
    
    @Override
    public boolean isWarned(Event event) {
        Query query1 = em.createQuery("Select distinct e From Event e, Notification n, Forecast f Where n.event= :event and e.outdoor=1 and f.place=e.place and CAST(f.date AS DATE) between CAST(e.startTime AS DATE) and CAST(e.endTime AS DATE) and f.mainCondition not in ('Clear') ").setParameter("event", event);
        List<Event> eventWarning = query1.getResultList();
        return !eventWarning.isEmpty();
    }
    
    @Override
    public List<Event> findWarnings(Users creator) {

        Query query1 = em.createQuery("Select distinct e From Event e, Notification n, Forecast f Where n.event=e and n.creator=1 and e.outdoor=1 and e.creator.mail= :mail and f.place=e.place and CAST(f.date AS DATE) between  CAST(e.startTime AS DATE) and  CAST(e.endTime AS DATE) and f.mainCondition not in ('Clear') ").setParameter("mail", creator.getMail());
        List<Event> eventWarning = query1.getResultList();

        return eventWarning;
    }
    
//    @Override
//    public List<Timestamp> findSolution(List<Event> eventWarning) {
//
//        int day;
//        long dayy;
//        Timestamp help;
//        Query queryForecast, queryMain;
//        List<Forecast> forecast;
//        List<Timestamp> daySuggest = new ArrayList<>();
//        List<MainCondition> condition;
//        for (int i = 0; i < eventWarning.size(); i++) {
//            dayy = eventWarning.get(i).getEndTime().getTime() - eventWarning.get(i).getStartTime().getTime();
//            if (dayy / (1000 * 60 * 60 * 24) < 1) {
//                day = 1;
//            } else {
//                day = (int) (dayy / (1000 * 60 * 60 * 24));
//            }
//
//            queryForecast = em.createQuery("Select  distinct f From Forecast f where f.place= :place and CAST(f.date AS DATE) > CAST(:startTime AS DATE)").setParameter(("place"), eventWarning.get(i).getPlace()).setParameter("startTime", eventWarning.get(i).getStartTime());
//            forecast = queryForecast.getResultList();
//
//            //queryMain = em.createQuery("Select distinct p.main From Preference p where p.event.idEvent = :id").setParameter(("id"), eventWarning.get(i).getIdEvent());
//            //condition = queryMain.getResultList();
//            if (forecast.isEmpty()) {
//                daySuggest.add(null);
//            } else {
//                for (int j = 0, daysOk = 0; j < forecast.size() && daysOk < day; j++) {
//                    //if (condition.contains(forecast.get(j).getMainCondition())) {
//                        if (daysOk == 0) {
//
//                            help = forecast.get(j).getDate();
//                            help.setHours(eventWarning.get(i).getStartTime().getHours());
//                            help.setMinutes(eventWarning.get(i).getStartTime().getMinutes());
//                            help.setSeconds(eventWarning.get(i).getStartTime().getSeconds());
//                            daySuggest.add(i, help);
//
//                        }
//                        daysOk++;
//                    } else {
//                        daySuggest.add(i, null);
//                        daysOk = 0;
//                    }
//                }
//            }
//        }
//
//        return daySuggest;
//
//    }
    
}
