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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
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
@Table(name = "invitation")
@XmlRootElement

public class Invitation implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy=GenerationType.AUTO)//crea automaticamente un valore per questo attributo
    @Column(name = "idInvitation")
    private Integer idInvitation;
    
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    
    @Lob
    @Column(name = "text")
    private byte[] text;
    
    @JoinColumn(name = "Event_idEvent", referencedColumnName = "idEvent")
    @ManyToOne
    private Event eventidEvent;
    
    @JoinColumn(name = "Users_idUsers", referencedColumnName = "idUsers")
    @ManyToOne
    private Users usersidUsers;

    public Invitation() {
    }

    public Invitation(Integer idInvitation) {
        this.idInvitation = idInvitation;
    }

    public Integer getIdInvitation() {
        return idInvitation;
    }

    public void setIdInvitation(Integer idInvitation) {
        this.idInvitation = idInvitation;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public byte[] getText() {
        return text;
    }

    public void setText(byte[] text) {
        this.text = text;
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
        hash += (idInvitation != null ? idInvitation.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invitation)) {
            return false;
        }
        Invitation other = (Invitation) object;
        if ((this.idInvitation == null && other.idInvitation != null) || (this.idInvitation != null && !this.idInvitation.equals(other.idInvitation))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MeteoCal.business.security.entity.Invitation[ idInvitation=" + idInvitation + " ]";
    }
    
}
