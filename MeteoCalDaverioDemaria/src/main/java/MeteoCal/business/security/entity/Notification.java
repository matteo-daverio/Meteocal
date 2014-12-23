/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.business.security.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DeMaria
 */
@Entity
@Table(name = "notification")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Notification1.findAll", query = "SELECT n FROM Notification1 n"),
    @NamedQuery(name = "Notification1.findByIdNotification", query = "SELECT n FROM Notification1 n WHERE n.notification1PK.idNotification = :idNotification"),
    @NamedQuery(name = "Notification1.findByDate", query = "SELECT n FROM Notification1 n WHERE n.date = :date"),
    @NamedQuery(name = "Notification1.findByUsersidUsers", query = "SELECT n FROM Notification1 n WHERE n.notification1PK.usersidUsers = :usersidUsers"),
    @NamedQuery(name = "Notification1.findByUsersCalendaridCalendar", query = "SELECT n FROM Notification1 n WHERE n.notification1PK.usersCalendaridCalendar = :usersCalendaridCalendar"),
    @NamedQuery(name = "Notification1.findByEventidEvent", query = "SELECT n FROM Notification1 n WHERE n.notification1PK.eventidEvent = :eventidEvent"),
    @NamedQuery(name = "Notification1.findByEventUsersidUsers", query = "SELECT n FROM Notification1 n WHERE n.notification1PK.eventUsersidUsers = :eventUsersidUsers")})
public class Notification implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected NotificationPK notification1PK;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @JoinColumns({
        @JoinColumn(name = "Event_idEvent", referencedColumnName = "idEvent", insertable = false, updatable = false),
        @JoinColumn(name = "Event_Users_idUsers", referencedColumnName = "Users_idUsers", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Event event1;
    @JoinColumns({
        @JoinColumn(name = "Users_idUsers", referencedColumnName = "idUsers", insertable = false, updatable = false),
        @JoinColumn(name = "Users_Calendar_idCalendar", referencedColumnName = "Calendar_idCalendar", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Users users1;

    public Notification() {
    }

    public Notification(NotificationPK notification1PK) {
        this.notification1PK = notification1PK;
    }

    public Notification(int idNotification, int usersidUsers, int usersCalendaridCalendar, int eventidEvent, int eventUsersidUsers) {
        this.notification1PK = new NotificationPK(idNotification, usersidUsers, usersCalendaridCalendar, eventidEvent, eventUsersidUsers);
    }

    public NotificationPK getNotification1PK() {
        return notification1PK;
    }

    public void setNotification1PK(NotificationPK notification1PK) {
        this.notification1PK = notification1PK;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Event getEvent1() {
        return event1;
    }

    public void setEvent1(Event event1) {
        this.event1 = event1;
    }

    public Users getUsers1() {
        return users1;
    }

    public void setUsers1(Users users1) {
        this.users1 = users1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (notification1PK != null ? notification1PK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notification)) {
            return false;
        }
        Notification other = (Notification) object;
        if ((this.notification1PK == null && other.notification1PK != null) || (this.notification1PK != null && !this.notification1PK.equals(other.notification1PK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MeteoCal.business.security.entity.Notification1[ notification1PK=" + notification1PK + " ]";
    }
    
}
