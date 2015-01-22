/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.business.security.boundary;

import MeteoCal.business.security.entity.Place;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Matteo
 */
@Stateless
@Remote(PlaceManagerInterface.class)
public class PlaceManager implements PlaceManagerInterface {
    
    
    @PersistenceContext
    private EntityManager em;
    
    
    /**
     * return All Places in DB
     *
     * @return
     */
    @Override
    public List<Place> getAllPlaces() {

        try {
            Query query = em.createNativeQuery("SELECT * FROM Place");

            List<String> list = (List<String>) query.getResultList();

            List<Place> listPlace = new ArrayList<>();

            for (String s : list) {
                listPlace.add(em.find(Place.class, s));
            }

            return listPlace;

        } catch (Exception e) {
            System.out.println("Errore nella query getAllPlaces");
            System.out.println(e);
        }
        return null;
    }
    
}
