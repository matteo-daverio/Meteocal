/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.gui.security;

import java.util.Date;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author Matteo
 */

@Named
@RequestScoped
public class DateBean {
    private Date date;
    
    // Date getter
    public Date getDate(){
        return date;
    }
    
    // Date setter
    public void setDate(Date date){
        this.date=date;
    }
}
