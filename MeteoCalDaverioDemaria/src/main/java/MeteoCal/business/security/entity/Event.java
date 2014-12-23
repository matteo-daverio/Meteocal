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
    @NamedQuery(name = "Event1.findAll", query = "SELECT e FROM Event1 e"),
    @NamedQuery(name = "Event1.findByIdEvent", query = "SELECT e FROM Event1 e WHERE e.event1PK.idEvent = :idEvent"),
    @NamedQuery(name = "Event1.findByIsPublic", query = "SELECT e FROM Event1 e WHERE e.isPublic = :isPublic"),
    @NamedQuery(name = "Event1.findByWhere", query = "SELECT e FROM Event1 e WHERE e.where = :where"),
    @NamedQuery(name = "Event1.findByIsOutdoor", query = "SELECT e FROM Event1 e WHERE e.isOutdoor = :isOutdoor"),
    @NamedQuery(name = "Event1.findByWeather", query = "SELECT e FROM Event1 e WHERE e.weather = :weather"),
    @NamedQuery(name = "Event1.findByStartTime", query = "SELECT e FROM Event1 e WHERE e.startTime = :startTime"),
    @NamedQuery(name = "Event1.findByEndTime", query = "SELECT e FROM Event1 e WHERE e.endTime = :endTime"),
    @NamedQuery(name = "Event1.findByDate", query = "SELECT e FROM Event1 e WHERE e.date = :date"),
    @NamedQuery(name = "Event1.findByUsersidUsers", query = "SELECT e FROM Event1 e WHERE e.event1PK.usersidUsers = :usersidUsers")})
public class Event implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EventPK event1PK;
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
    private Collection<Users> users1Collection;
    @ManyToMany(mappedBy = "event1Collection")
    private Collection<Calendar> calendar1Collection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event1")
    private Collection<Notification> notification1Collection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "event1")
    private Collection<Invitation> invitation1Collection;
    @JoinColumn(name = "Users_idUsers", referencedColumnName = "idUsers", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Users users1;

    public Event() {
    }

    public Event(EventPK event1PK) {
        this.event1PK = event1PK;
    }

    public Event(int idEvent, int usersidUsers) {
        this.event1PK = new EventPK(idEvent, usersidUsers);
    }

    public EventPK getEvent1PK() {
        return event1PK;
    }

    public void setEvent1PK(EventPK event1PK) {
        this.event1PK = event1PK;
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
    public Collection<Users> getUsers1Collection() {
        return users1Collection;
    }

    public void setUsers1Collection(Collection<Users> users1Collection) {
        this.users1Collection = users1Collection;
    }

    @XmlTransient
    public Collection<Calendar> getCalendar1Collection() {
        return calendar1Collection;
    }

    public void setCalendar1Collection(Collection<Calendar> calendar1Collection) {
        this.calendar1Collection = calendar1Collection;
    }

    @XmlTransient
    public Collection<Notification> getNotification1Collection() {
        return notification1Collection;
    }

    public void setNotification1Collection(Collection<Notification> notification1Collection) {
        this.notification1Collection = notification1Collection;
    }

    @XmlTransient
    public Collection<Invitation> getInvitation1Collection() {
        return invitation1Collection;
    }

    public void setInvitation1Collection(Collection<Invitation> invitation1Collection) {
        this.invitation1Collection = invitation1Collection;
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
        hash += (event1PK != null ? event1PK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Event)) {
            return false;
        }
        Event other = (Event) object;
        if ((this.event1PK == null && other.event1PK != null) || (this.event1PK != null && !this.event1PK.equals(other.event1PK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MeteoCal.business.security.entity.Event1[ event1PK=" + event1PK + " ]";
    }
    
}
