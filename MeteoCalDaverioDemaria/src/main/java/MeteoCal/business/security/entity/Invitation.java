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
import javax.persistence.Lob;
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
@Table(name = "invitation")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Invitation.findAll", query = "SELECT i FROM Invitation i"),
    @NamedQuery(name = "Invitation.findByIdNotification", query = "SELECT i FROM Invitation i WHERE i.invitationPK.idNotification = :idNotification"),
    @NamedQuery(name = "Invitation.findByDate", query = "SELECT i FROM Invitation i WHERE i.date = :date"),
    @NamedQuery(name = "Invitation.findByUsersidUsers", query = "SELECT i FROM Invitation i WHERE i.invitationPK.usersidUsers = :usersidUsers"),
    @NamedQuery(name = "Invitation.findByUsersCalendaridCalendar", query = "SELECT i FROM Invitation i WHERE i.invitationPK.usersCalendaridCalendar = :usersCalendaridCalendar"),
    @NamedQuery(name = "Invitation.findByEventidEvent", query = "SELECT i FROM Invitation i WHERE i.invitationPK.eventidEvent = :eventidEvent"),
    @NamedQuery(name = "Invitation.findByEventUsersidUsers", query = "SELECT i FROM Invitation i WHERE i.invitationPK.eventUsersidUsers = :eventUsersidUsers")})
public class Invitation implements Serializable {
    private static final long serialVersionUID = 1L;
    
    //ATTRIBUTES
    @EmbeddedId
    protected InvitationPK invitationPK;
    
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    
    @Lob
    @Column(name = "text")
    private byte[] text;
    
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
    
    public Invitation() {
    }

    public Invitation(InvitationPK invitationPK) {
        this.invitationPK = invitationPK;
    }

    public Invitation(int idNotification, int usersidUsers, int usersCalendaridCalendar, int eventidEvent, int eventUsersidUsers) {
        this.invitationPK = new InvitationPK(idNotification, usersidUsers, usersCalendaridCalendar, eventidEvent, eventUsersidUsers);
    }

    //GETTERS AND SETTERS
    
    public InvitationPK getInvitationPK() {
        return invitationPK;
    }

    public void setInvitationPK(InvitationPK invitationPK) {
        this.invitationPK = invitationPK;
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
        hash += (invitationPK != null ? invitationPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invitation)) {
            return false;
        }
        Invitation other = (Invitation) object;
        if ((this.invitationPK == null && other.invitationPK != null) || (this.invitationPK != null && !this.invitationPK.equals(other.invitationPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MeteoCal.business.security.entity.Invitation[ invitationPK=" + invitationPK + " ]";
    }
    
}
