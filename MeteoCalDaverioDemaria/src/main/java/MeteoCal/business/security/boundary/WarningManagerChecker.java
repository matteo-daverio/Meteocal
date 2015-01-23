/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.business.security.boundary;

import MeteoCal.business.security.entity.Event;
import MeteoCal.business.security.entity.Users;
import java.sql.Timestamp;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Schedule;
import javax.ejb.Schedules;
import javax.ejb.Singleton;

/**
 *
 * @author DeMaria
 */
@Singleton
@Remote(WarningManagerCheckerInterface.class)
public class WarningManagerChecker implements WarningManagerCheckerInterface {
 
    
    /**
     *
     * MANAGERS
     *
     */
    @EJB
    private BadWeatherManagerInterface bm;

    @EJB
    private NotificationManagerInterface nm;

    int count = 0;

    /**
     * this function check every 12 hours if there are some bad weather
     * notifications. If there are, this function sents email to creators
     */
    @Schedules({
        @Schedule(second = "0", minute = "0", hour = "0", persistent = false),
        @Schedule(second = "0", minute = "0", hour = "12", persistent = false)
    })
    
//    private void warningEvery12Hours() {
//
//        System.out.println("Begin warningEvery12Hours " + count);
//        count++;
//
//        List<Users> users = nm.getUsersCreator();
//        Iterator<Users> ite = users.iterator();
//        while (ite.hasNext()) {
//            Users u = ite.next();
//            List<Event> eventWarning = bm.findWarnings(u);
//
//
//        }
//    }

    /**
     * this function checks if there are warnings for events that start in three
     * days If there are, this function sents email to creators
     */
    @Schedule(second = "0", minute = "0", hour = "0", persistent = false)
    private void threeDaysWarning() {

        System.out.println("Inizio check three day warning");
        Timestamp now = new Timestamp(new java.util.Date().getTime());

        long deltaThreeDay = 3 * (24 * 60 * 60 * 1000);

        long deltaTwoDay = 2 * (24 * 60 * 60 * 1000);
        long nowLong = now.getTime();

        //Get all users
        List<Users> users = nm.getUsersCreator();
        //Get all warnings
        Iterator<Users> ite = users.iterator();
        while (ite.hasNext()) {
            Users u = ite.next();
            List<Event> eventWarning = bm.findWarnings(u);

            for (Event e : eventWarning) {

                long d = e.getStartTime().getTime();

            }
        }
        System.out.println("Fine check three day warning");
    }

    /**
     * this functions checks if there are some bad weather notification for
     * events strarting in one day. If there are, the function sents email to
     * invitees
     */
    @Schedule(second = "0", minute = "0", hour = "0", persistent = false)
    private void oneDayWarning() {

        System.out.println("Inizio check one day warning");
        Timestamp now = new Timestamp(new java.util.Date().getTime());

        long deltaOneDay = (24 * 60 * 60 * 1000);

        long nowLong = now.getTime();

        List<Users> users = nm.getUsersCreator();
        //Get all warnings
        Iterator<Users> ite = users.iterator();
        while (ite.hasNext()) {
            Users u = ite.next();
            List<Event> eventWarning = bm.findWarnings(u);

            for (Event e : eventWarning) {

                long d = e.getStartTime().getTime();

                if (d - nowLong >= 0 && d - nowLong <= deltaOneDay) {
                    List<Users> invited = nm.getInvitedWhoAccepted(e);
                }
            }
        }
        System.out.println("Fine check one day warning");
    }
    
}
