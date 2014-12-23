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
    @NamedQuery(name = "Invitation1.findAll", query = "SELECT i FROM Invitation1 i"),
    @NamedQuery(name = "Invitation1.findByIdNotification", query = "SELECT i FROM Invitation1 i WHERE i.invitation1PK.idNotification = :idNotification"),
    @NamedQuery(name = "Invitation1.findByDate", query = "SELECT i FROM Invitation1 i WHERE i.date = :date"),
    @NamedQuery(name = "Invitation1.findByUsersidUsers", query = "SELECT i FROM Invitation1 i WHERE i.invitation1PK.usersidUsers = :usersidUsers"),
    @NamedQuery(name = "Invitation1.findByUsersCalendaridCalendar", query = "SELECT i FROM Invitation1 i WHERE i.invitation1PK.usersCalendaridCalendar = :usersCalendaridCalendar"),
    @NamedQuery(name = "Invitation1.findByEventidEvent", query = "SELECT i FROM Invitation1 i WHERE i.invitation1PK.eventidEvent = :eventidEvent"),
    @NamedQuery(name = "Invitation1.findByEventUsersidUsers", query = "SELECT i FROM Invitation1 i WHERE i.invitation1PK.eventUsersidUsers = :eventUsersidUsers")})
public class Invitation implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected InvitationPK invitation1PK;
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
    private Event event1;
    @JoinColumns({
        @JoinColumn(name = "Users_idUsers", referencedColumnName = "idUsers", insertable = false, updatable = false),
        @JoinColumn(name = "Users_Calendar_idCalendar", referencedColumnName = "Calendar_idCalendar", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private Users users1;

    public Invitation() {
    }

    public Invitation(InvitationPK invitation1PK) {
        this.invitation1PK = invitation1PK;
    }

    public Invitation(int idNotification, int usersidUsers, int usersCalendaridCalendar, int eventidEvent, int eventUsersidUsers) {
        this.invitation1PK = new InvitationPK(idNotification, usersidUsers, usersCalendaridCalendar, eventidEvent, eventUsersidUsers);
    }

    public InvitationPK getInvitation1PK() {
        return invitation1PK;
    }

    public void setInvitation1PK(InvitationPK invitation1PK) {
        this.invitation1PK = invitation1PK;
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
        hash += (invitation1PK != null ? invitation1PK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Invitation)) {
            return false;
        }
        Invitation other = (Invitation) object;
        if ((this.invitation1PK == null && other.invitation1PK != null) || (this.invitation1PK != null && !this.invitation1PK.equals(other.invitation1PK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MeteoCal.business.security.entity.Invitation1[ invitation1PK=" + invitation1PK + " ]";
    }
    
}
