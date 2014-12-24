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
    @NamedQuery(name = "Notification.findAll", query = "SELECT n FROM Notification n"),
    @NamedQuery(name = "Notification.findByIdNotification", query = "SELECT n FROM Notification n WHERE n.notificationPK.idNotification = :idNotification"),
    @NamedQuery(name = "Notification.findByDate", query = "SELECT n FROM Notification n WHERE n.date = :date"),
    @NamedQuery(name = "Notification.findByUsersidUsers", query = "SELECT n FROM Notification n WHERE n.notificationPK.usersidUsers = :usersidUsers"),
    @NamedQuery(name = "Notification.findByUsersCalendaridCalendar", query = "SELECT n FROM Notification n WHERE n.notificationPK.usersCalendaridCalendar = :usersCalendaridCalendar"),
    @NamedQuery(name = "Notification.findByEventidEvent", query = "SELECT n FROM Notification n WHERE n.notificationPK.eventidEvent = :eventidEvent"),
    @NamedQuery(name = "Notification.findByEventUsersidUsers", query = "SELECT n FROM Notification n WHERE n.notificationPK.eventUsersidUsers = :eventUsersidUsers")})
public class Notification implements Serializable {
    private static final long serialVersionUID = 1L;
    
    //ATTRIBUTES
    
    @EmbeddedId
    protected NotificationPK notificationPK;
    
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    
    @JoinColumns({
        @JoinColumn(name = "Event_idEvent", referencedColumnName = "idEvent", insertable = false, updatable = false),
        @JoinColumn(name = "Event_Users_idUsers", referencedColumnName = "Users_idUsers", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Event event;
    
    @JoinColumns({
        @JoinColumn(name = "Users_idUsers", referencedColumnName = "idUsers", insertable = false, updatable = false),
        @JoinColumn(name = "Users_Calendar_idCalendar", referencedColumnName = "Calendar_idCalendar", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Users users;

    //COSTRUTTORI
    
    public Notification() {
    }

    public Notification(NotificationPK notificationPK) {
        this.notificationPK = notificationPK;
    }

    public Notification(int idNotification, int usersidUsers, int usersCalendaridCalendar, int eventidEvent, int eventUsersidUsers) {
        this.notificationPK = new NotificationPK(idNotification, usersidUsers, usersCalendaridCalendar, eventidEvent, eventUsersidUsers);
    }

    //GETTERS AND SETTERS
    
    public NotificationPK getNotificationPK() {
        return notificationPK;
    }

    public void setNotificationPK(NotificationPK notificationPK) {
        this.notificationPK = notificationPK;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (notificationPK != null ? notificationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notification)) {
            return false;
        }
        Notification other = (Notification) object;
        if ((this.notificationPK == null && other.notificationPK != null) || (this.notificationPK != null && !this.notificationPK.equals(other.notificationPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MeteoCal.business.security.entity.Notification[ notificationPK=" + notificationPK + " ]";
    }
    
}
