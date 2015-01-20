/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.business.security.entity;

import MeteoCal.businness.security.control.PasswordEncrypter;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
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
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idUsers")
    private Integer idUsers;
    
    @Size(max = 255)
    @Column(name = "mail")
    private String mail;
    
    @Size(max = 255)
    @Column(name = "name")
    private String name;
    
    @Size(max = 255)
    @Column(name = "psw")
    private String psw;
        
    @JoinTable(name = "participation", joinColumns = {
        @JoinColumn(name = "Users_idUsers", referencedColumnName = "idUsers")}, inverseJoinColumns = {
        @JoinColumn(name = "Event_idEvent", referencedColumnName = "idEvent")})
    @ManyToMany
    private Collection<Event> eventCollection;
    
    @OneToMany(mappedBy = "usersidUsers")
    private Collection<Notification> notificationCollection;
    
    @OneToMany(mappedBy = "usersidUsers")
    private Collection<Invitation> invitationCollection;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usersidUsers")
    private Collection<Event> eventCollection1;
    
    @JoinColumn(name = "Calendar_idCalendar", referencedColumnName = "idCalendar")
    @ManyToOne
    private Calendar calendaridCalendar;

    public Users() {
    }

    public Users(Integer idUsers) {
        this.idUsers = idUsers;
    }

    public Integer getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(Integer idUsers) {
        this.idUsers = idUsers;
    }
    
    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPsw() {
        return psw;
    }

    public void setPsw(String psw) {
        this.psw = PasswordEncrypter.encryptPassword(psw);
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

    public Calendar getCalendaridCalendar() {
        return calendaridCalendar;
    }

    public void setCalendaridCalendar(Calendar calendaridCalendar) {
        this.calendaridCalendar = calendaridCalendar;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsers != null ? idUsers.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.idUsers == null && other.idUsers != null) || (this.idUsers != null && !this.idUsers.equals(other.idUsers))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MeteoCal.business.security.entity.Users[ idUsers=" + idUsers + " ]";
    }
    
}
