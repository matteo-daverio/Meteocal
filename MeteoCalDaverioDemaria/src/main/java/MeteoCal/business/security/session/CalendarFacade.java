/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.business.security.session;

import MeteoCal.business.security.entity.Calendar;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author DeMaria
 */
@Stateless
public class CalendarFacade extends AbstractFacade<Calendar> {
    @PersistenceContext(unitName = "com.mycompany_MeteoCalDaverioDemaria_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CalendarFacade() {
        super(Calendar.class);
    }
    
}