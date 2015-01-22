/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.business.security.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 *
 * @author DeMaria
 */
@Entity
public class Place implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @NotNull(message = "May not be empty")
    private String city;


    //getters and setters
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city.toLowerCase();
    }

    
    ///CONSTRUCTORS
    
    public Place() {

    }

    public Place(String city) {
        this.city = city.toLowerCase();
    }

    
}
