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
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "invitation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invitation.findAll", query = "SELECT i FROM Invitation i"),
    @NamedQuery(name = "Invitation.findByIdInvitation", query = "SELECT i FROM Invitation i WHERE i.idInvitation = :idInvitation"),
    @NamedQuery(name = "Invitation.findByDate", query = "SELECT i FROM Invitation i WHERE i.date = :date"),
    @NamedQuery(name = "Invitation.findByUsersidUsers", query = "SELECT i FROM Invitation i WHERE i.usersidUsers = :usersidUsers"),
    @NamedQuery(name = "Invitation.findByEventidEvent", query = "SELECT i FROM Invitation i WHERE i.eventidEvent = :eventidEvent")})
public class Invitation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idInvitation")
    private Integer idInvitation;
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Lob
    @Column(name = "text")
    private byte[] text;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Users_idUsers")
    private int usersidUsers;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Event_idEvent")
    private int eventidEvent;

    public Invitation() {
    }

    public Invitation(Integer idInvitation) {
        this.idInvitation = idInvitation;
    }

    public Invitation(Integer idInvitation, int usersidUsers, int eventidEvent) {
        this.idInvitation = idInvitation;
        this.usersidUsers = usersidUsers;
        this.eventidEvent = eventidEvent;
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

    public int getUsersidUsers() {
        return usersidUsers;
    }

    public void setUsersidUsers(int usersidUsers) {
        this.usersidUsers = usersidUsers;
    }

    public int getEventidEvent() {
        return eventidEvent;
    }

    public void setEventidEvent(int eventidEvent) {
        this.eventidEvent = eventidEvent;
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
