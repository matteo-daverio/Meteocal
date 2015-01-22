/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.business.security.boundary;

import MeteoCal.business.security.entity.Event;
import MeteoCal.business.security.entity.Forecast;
import MeteoCal.business.security.entity.Place;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author Matteo
 */
@Remote
public interface ForecastManagerInterface {
 
    public List<Forecast> getForecastInPlace(Place place);

    public List<Forecast> getForecastOfEvent(Event event);
    
}
