/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.business.security.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DeMaria
 */
@Entity
@Table(name = "event")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Event.findAll", query = "SELECT e FROM Event e"),
    @NamedQuery(name = "Event.findByIdEvent", query = "SELECT e FROM Event e WHERE e.eventPK.idEvent = :idEvent"),
    @NamedQuery(name = "Event.findByIsPublic", query = "SELECT e FROM Event e WHERE e.isPublic = :isPublic"),
    @NamedQuery(name = "Event.findByWhere", query = "SELECT e FROM Event e WHERE e.where = :where"),
    @NamedQuery(name = "Event.findByIsOutdoor", query = "SELECT e FROM Event e WHERE e.isOutdoor = :isOutdoor"),
    @NamedQuery(name = "Event.findByWeather", query = "SELECT e FROM Event e WHERE e.weather = :weather"),
    @NamedQuery(name = "Event.findByStartTime", query = "SELECT e FROM Event e WHERE e.startTime = :startTime"),
    @NamedQuery(name = "Event.findByEndTime", query = "SELECT e FROM Event e WHERE e.endTime = :endTime"),
    @NamedQuery(name = "Event.findByDate", query = "SELECT e FROM Event e WHERE e.date = :date"),
    @NamedQuery(name = "Event.findByUsersidUsers", query = "SELECT e FROM Event e WHERE e.eventPK.usersidUsers = :usersidUsers")})
public class Event implements Serializable {
    private static final long serialVersionUID = 1L;
    
    //ATTRIBUTES
    
    @EmbeddedId
    protected EventPK eventPK;
    
    @Column(name = "isPublic")
    private Boolean isPublic;
    
    @Size(max = 45)
    @Column(name = "where")
    private String where;
    
    @Column(name = "isOutdoor")
    private Boolean isOutdoor;
    
    @Size(max = 45)
    @Column(name = "weather")
    private String weather;
    
    @Column(name = "startTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date startTime;
    
    @Column(name = "endTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Date endTime;
    
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    
    @JoinTable(name = "participation", joinColumns = {
        @JoinColumn(name = "Event_idEvent", referencedColumnName = "idEvent")}, inverseJoinColumns = {
        @JoinColumn(name = "Users_idUsers", referencedColumnName = "idUsers")})
    @ManyToMany
    private Collection<Users> usersCollection;
    
    @ManyToMany(mappedBy = "eventCollection")
    private Collection<Calendar> calendarCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
    private Collection<Notification> notificationCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event")
    private Collection<Invitation> invitationCollection;
    
    @JoinColumn(name = "Users_idUsers", referencedColumnName = "idUsers", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Users users;

    //COSTRUTTORI
    
    public Event() {
    }

    public Event(EventPK eventPK) {
        this.eventPK = eventPK;
    }

    public Event(int idEvent, int usersidUsers) {
        this.eventPK = new EventPK(idEvent, usersidUsers);
    }

    //GETTERS AND SETTERS
    
    public EventPK getEventPK() {
        return eventPK;
    }

    public void setEventPK(EventPK eventPK) {
        this.eventPK = eventPK;
    }

    public Boolean getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }

    public String getWhere() {
        return where;
    }

    public void setWhere(String where) {
        this.where = where;
    }

    public Boolean getIsOutdoor() {
        return isOutdoor;
    }

    public void setIsOutdoor(Boolean isOutdoor) {
        this.isOutdoor = isOutdoor;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @XmlTransient
    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    @XmlTransient
    public Collection<Calendar> getCalendarCollection() {
        return calendarCollection;
    }

    public void setCalendarCollection(Collection<Calendar> calendarCollection) {
        this.calendarCollection = calendarCollection;
    }

    @XmlTransient
    public Collection<Notification> getNotificationCollection() {
        return notificationCollection;
    }

    public void setNotificationCollection(Collection<Notification> notificationCollection) {
        this.notificationCollection = notificationCollection;
    }

    @XmlTransient
    public Collection<Invitation> getInvitationCollection() {
        return invitationCollection;
    }

    public void setInvitationCollection(Collection<Invitation> invitationCollection) {
        this.invitationCollection = invitationCollection;
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
        hash += (eventPK != null ? eventPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Event)) {
            return false;
        }
        Event other = (Event) object;
        if ((this.eventPK == null && other.eventPK != null) || (this.eventPK != null && !this.eventPK.equals(other.eventPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MeteoCal.business.security.entity.Event[ eventPK=" + eventPK + " ]";
    }
    
}
