/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.business.security.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DeMaria
 */
@Entity
@Table(name = "notification")

@NamedQueries({
    //@NamedQuery(name= Users.findAll, query = "SELECT u FROM Users u"),
    //@NamedQuery(name= Users.count, query="SELECT count(u) FROM Users u"),

})
public class Notification implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy=GenerationType.AUTO)//crea automaticamente un valore per questo attributo
    @Column(name = "idNotification")
    private Integer idNotification;
    
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    
    @JoinColumn(name = "Event_idEvent", referencedColumnName = "idEvent")
    @ManyToOne
    private Event eventidEvent;
    
    @JoinColumn(name = "Users_idUsers", referencedColumnName = "idUsers")
    @ManyToOne
    private Users usersidUsers;

    public Notification() {
    }

    public Notification(Integer idNotification) {
        this.idNotification = idNotification;
    }

    public Integer getIdNotification() {
        return idNotification;
    }

    public void setIdNotification(Integer idNotification) {
        this.idNotification = idNotification;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Event getEventidEvent() {
        return eventidEvent;
    }

    public void setEventidEvent(Event eventidEvent) {
        this.eventidEvent = eventidEvent;
    }

    public Users getUsersidUsers() {
        return usersidUsers;
    }

    public void setUsersidUsers(Users usersidUsers) {
        this.usersidUsers = usersidUsers;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idNotification != null ? idNotification.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Notification)) {
            return false;
        }
        Notification other = (Notification) object;
        if ((this.idNotification == null && other.idNotification != null) || (this.idNotification != null && !this.idNotification.equals(other.idNotification))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MeteoCal.business.security.entity.Notification[ idNotification=" + idNotification + " ]";
    }
    
}
