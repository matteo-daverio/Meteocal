/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.business.security.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author DeMaria
 */
@Entity
public class MainCondition implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    String conditione;

    
    //GETTERS AND SETTERS
    public String getCondition() {
        return conditione;
    }

    public void setCondition(String Condition) {
        this.conditione = Condition;
    }

     
    /**
     * List of Strings with name of possible MainCondition
     *
     * @return
     */
    public static List<String> getListPref() {
        List<String> pref = new ArrayList<>();
        pref.add("Clear");
        pref.add("Clouds");
        pref.add("Rain");
        pref.add("Snow");
        return pref;
    }

    
}
