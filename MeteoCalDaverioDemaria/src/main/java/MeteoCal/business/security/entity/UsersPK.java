/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.business.security.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author DeMaria
 */
@Embeddable
public class UsersPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUsers")
    private int idUsers;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Calendar_idCalendar")
    private int calendaridCalendar;

    public UsersPK() {
    }

    public UsersPK(int idUsers, int calendaridCalendar) {
        this.idUsers = idUsers;
        this.calendaridCalendar = calendaridCalendar;
    }

    public int getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(int idUsers) {
        this.idUsers = idUsers;
    }

    public int getCalendaridCalendar() {
        return calendaridCalendar;
    }

    public void setCalendaridCalendar(int calendaridCalendar) {
        this.calendaridCalendar = calendaridCalendar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idUsers;
        hash += (int) calendaridCalendar;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsersPK)) {
            return false;
        }
        UsersPK other = (UsersPK) object;
        if (this.idUsers != other.idUsers) {
            return false;
        }
        if (this.calendaridCalendar != other.calendaridCalendar) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MeteoCal.business.security.entity.Users1PK[ idUsers=" + idUsers + ", calendaridCalendar=" + calendaridCalendar + " ]";
    }
    
}
