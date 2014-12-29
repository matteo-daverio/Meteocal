/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.business.security.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DeMaria
 */
@Entity
@Table(name = "users")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByIdUsers", query = "SELECT u FROM Users u WHERE u.usersPK.idUsers = :idUsers"),
    @NamedQuery(name = "Users.findByName", query = "SELECT u FROM Users u WHERE u.name = :name"),
    @NamedQuery(name = "Users.findBySurname", query = "SELECT u FROM Users u WHERE u.surname = :surname"),
    @NamedQuery(name = "Users.findByMail", query = "SELECT u FROM Users u WHERE u.mail = :mail"),
    @NamedQuery(name = "Users.findByPsw", query = "SELECT u FROM Users u WHERE u.psw = :psw"),
    @NamedQuery(name = "Users.findByCalendaridCalendar", query = "SELECT u FROM Users u WHERE u.usersPK.calendaridCalendar = :calendaridCalendar")})
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    
    
    
    //ATTRIBUTES
    
    @EmbeddedId
    protected UsersPK usersPK;
    @Size(max = 45)
    
    @Column(name = "name")
    private String name;
    @Size(max = 45)
    
    @Column(name = "surname")
    private String surname;
    @Size(max = 45)
    
    @Column(name = "mail")
    private String mail;
    @Size(max = 45)
    
    @Column(name = "psw")
    private String psw;
    
    @ManyToMany(mappedBy = "usersCollection")
    private Collection<Event> eventCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private Collection<Notification> notificationCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private Collection<Invitation> invitationCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users")
    private Collection<Event> eventCollection1;
    
    @JoinColumn(name = "Calendar_idCalendar", referencedColumnName = "idCalendar", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Calendar calendar;

    //COSTRUTTORI
    
    public Users() {
    }

    public Users(UsersPK usersPK) {
        this.usersPK = usersPK;
    }

    public Users(int idUsers, int calendaridCalendar) {
        this.usersPK = new UsersPK(idUsers, calendaridCalendar);
    }

    //GETTERS AND SETTERS
    
    public UsersPK getUsersPK() {
        return usersPK;
    }

    public void setUsersPK(UsersPK usersPK) {
        this.usersPK = usersPK;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = psw;
    }

    @XmlTransient
    public Collection<Event> getEventCollection() {
        return eventCollection;
    }

    public void setEventCollection(Collection<Event> eventCollection) {
        this.eventCollection = eventCollection;
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

    @XmlTransient
    public Collection<Event> getEventCollection1() {
        return eventCollection1;
    }

    public void setEventCollection1(Collection<Event> eventCollection1) {
        this.eventCollection1 = eventCollection1;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usersPK != null ? usersPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.usersPK == null && other.usersPK != null) || (this.usersPK != null && !this.usersPK.equals(other.usersPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MeteoCal.business.security.entity.Users[ usersPK=" + usersPK + " ]";
    }
    
}
