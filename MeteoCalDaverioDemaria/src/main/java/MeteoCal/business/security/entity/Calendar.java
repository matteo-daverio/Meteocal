/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.business.security.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
    @NamedQuery(name = "Calendar1.findAll", query = "SELECT c FROM Calendar1 c"),
    @NamedQuery(name = "Calendar1.findByIdCalendar", query = "SELECT c FROM Calendar1 c WHERE c.idCalendar = :idCalendar"),
    @NamedQuery(name = "Calendar1.findByIsPublic", query = "SELECT c FROM Calendar1 c WHERE c.isPublic = :isPublic")})
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
        @JoinColumn(name = "Event_idEvent", referencedColumnName = "idEvent"),
        @JoinColumn(name = "Event_Users_idUsers", referencedColumnName = "Users_idUsers")})
    @ManyToMany
    private Collection<Event> event1Collection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "calendar1")
    private Collection<Users> users1Collection;

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
    public Collection<Event> getEvent1Collection() {
        return event1Collection;
    }

    public void setEvent1Collection(Collection<Event> event1Collection) {
        this.event1Collection = event1Collection;
    }

    @XmlTransient
    public Collection<Users> getUsers1Collection() {
        return users1Collection;
    }

    public void setUsers1Collection(Collection<Users> users1Collection) {
        this.users1Collection = users1Collection;
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
        return "MeteoCal.business.security.entity.Calendar1[ idCalendar=" + idCalendar + " ]";
    }
    
}
