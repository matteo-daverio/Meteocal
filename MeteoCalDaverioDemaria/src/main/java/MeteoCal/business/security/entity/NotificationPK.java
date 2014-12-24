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
public class NotificationPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "idNotification")
    private int idNotification;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Users_idUsers")
    private int usersidUsers;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Users_Calendar_idCalendar")
    private int usersCalendaridCalendar;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Event_idEvent")
    private int eventidEvent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Event_Users_idUsers")
    private int eventUsersidUsers;

    public NotificationPK() {
    }

    public NotificationPK(int idNotification, int usersidUsers, int usersCalendaridCalendar, int eventidEvent, int eventUsersidUsers) {
        this.idNotification = idNotification;
        this.usersidUsers = usersidUsers;
        this.usersCalendaridCalendar = usersCalendaridCalendar;
        this.eventidEvent = eventidEvent;
        this.eventUsersidUsers = eventUsersidUsers;
    }

    public int getIdNotification() {
        return idNotification;
    }

    public void setIdNotification(int idNotification) {
        this.idNotification = idNotification;
    }

    public int getUsersidUsers() {
        return usersidUsers;
    }

    public void setUsersidUsers(int usersidUsers) {
        this.usersidUsers = usersidUsers;
    }

    public int getUsersCalendaridCalendar() {
        return usersCalendaridCalendar;
    }

    public void setUsersCalendaridCalendar(int usersCalendaridCalendar) {
        this.usersCalendaridCalendar = usersCalendaridCalendar;
    }

    public int getEventidEvent() {
        return eventidEvent;
    }

    public void setEventidEvent(int eventidEvent) {
        this.eventidEvent = eventidEvent;
    }

    public int getEventUsersidUsers() {
        return eventUsersidUsers;
    }

    public void setEventUsersidUsers(int eventUsersidUsers) {
        this.eventUsersidUsers = eventUsersidUsers;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idNotification;
        hash += (int) usersidUsers;
        hash += (int) usersCalendaridCalendar;
        hash += (int) eventidEvent;
        hash += (int) eventUsersidUsers;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof NotificationPK)) {
            return false;
        }
        NotificationPK other = (NotificationPK) object;
        if (this.idNotification != other.idNotification) {
            return false;
        }
        if (this.usersidUsers != other.usersidUsers) {
            return false;
        }
        if (this.usersCalendaridCalendar != other.usersCalendaridCalendar) {
            return false;
        }
        if (this.eventidEvent != other.eventidEvent) {
            return false;
        }
        if (this.eventUsersidUsers != other.eventUsersidUsers) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MeteoCal.business.security.entity.NotificationPK[ idNotification=" + idNotification + ", usersidUsers=" + usersidUsers + ", usersCalendaridCalendar=" + usersCalendaridCalendar + ", eventidEvent=" + eventidEvent + ", eventUsersidUsers=" + eventUsersidUsers + " ]";
    }
    
}
