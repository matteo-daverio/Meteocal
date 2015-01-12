/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.business.security.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DeMaria
 */
@Entity
@Table(name = "calendar")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calendar.findAll", query = "SELECT c FROM Calendar c"),
    @NamedQuery(name = "Calendar.findByIdCalendar", query = "SELECT c FROM Calendar c WHERE c.idCalendar = :idCalendar"),
    @NamedQuery(name = "Calendar.findByIsPublic", query = "SELECT c FROM Calendar c WHERE c.isPublic = :isPublic")})
public class Calendar implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idCalendar")
    private Integer idCalendar;
    @Column(name = "isPublic")
    private Boolean isPublic;
    @JoinTable(name = "event_has_calendar", joinColumns = {
        @JoinColumn(name = "Calendar_idCalendar", referencedColumnName = "idCalendar")}, inverseJoinColumns = {
        @JoinColumn(name = "Event_idEvent", referencedColumnName = "idEvent")})
    @ManyToMany
    private Collection<Event> eventCollection;
    @OneToMany(mappedBy = "calendaridCalendar")
    private Collection<Users> usersCollection;

    public Calendar() {
    }

    public Calendar(Integer idCalendar) {
        this.idCalendar = idCalendar;
    }

    public Integer getIdCalendar() {
        return idCalendar;
    }

    public void setIdCalendar(Integer idCalendar) {
        this.idCalendar = idCalendar;
    }

    public Boolean getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }

    @XmlTransient
    public Collection<Event> getEventCollection() {
        return eventCollection;
    }

    public void setEventCollection(Collection<Event> eventCollection) {
        this.eventCollection = eventCollection;
    }

    @XmlTransient
    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCalendar != null ? idCalendar.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calendar)) {
            return false;
        }
        Calendar other = (Calendar) object;
        if ((this.idCalendar == null && other.idCalendar != null) || (this.idCalendar != null && !this.idCalendar.equals(other.idCalendar))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MeteoCal.business.security.entity.Calendar[ idCalendar=" + idCalendar + " ]";
    }
    
}
