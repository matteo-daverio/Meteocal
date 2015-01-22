/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.business.security.entity;

import MeteoCal.business.security.control.PasswordEncrypter;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 *
 * @author DeMaria
 */
@Entity
//@Table(name = "users")
//@NamedQueries({
    //@NamedQuery(name= Users.findAll, query = "SELECT u FROM Users u"),
    //@NamedQuery(name= Users.count, query="SELECT count(u) FROM Users u"),
    //@NamedQuery(name= Users.complete, query="SELECT u.name FROM Users u WHERE u.name LIKE ':value%'")
//})
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
   
    //public static final String findAll = "Users.findAll";
    //public static final String count = "Users.count";
    //public static final String complete ="Users.complete";
    
    //@Size(max = 255)
    //@Column(name = "mail")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String mail;
    
    //@Size(max = 255)
    //@Column(name = "name")
    private String name;
    
    //@Size(max = 255)
    //@Column(name = "psw")
    private String psw;
    
    @NotNull(message = "May not be empty")
    private String groupName;
    
    @NotNull
    private boolean publicCalendar = false;
    
//    @JoinTable(name = "participation", joinColumns = {
//        @JoinColumn(name = "Users_idUsers", referencedColumnName = "idUsers")}, inverseJoinColumns = {
//        @JoinColumn(name = "Event_idEvent", referencedColumnName = "idEvent")})
//    @ManyToMany
//    private Collection<Event> eventCollection;
    
//    @OneToMany(mappedBy = "usersidUsers")
//    private Collection<Notification> notificationCollection;
//    
//    @OneToMany(mappedBy = "usersidUsers")
//    private Collection<Invitation> invitationCollection;
//    
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usersidUsers")
//    private Collection<Event> eventCollection1;
//    
//    @JoinColumn(name = "Calendar_idCalendar", referencedColumnName = "idCalendar")
//    @ManyToOne
//    private Calendar calendaridCalendar;

  ///COSTRUTTORI  
    
    public Users() {
    }

//    public Users(Integer idUsers) {
//        this.idUsers = idUsers;
//    }
//
//    public Integer getIdUsers() {
//        return idUsers;
//    }
//
//    public void setIdUsers(Integer idUsers) {
//        this.idUsers = idUsers;
//    }
//    
    
  ////GETTERS AND SETTERS
    
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

    public void setGroupName(String groupName) {
       this.groupName = groupName;
    }

    public String getGroupName() {
        return groupName;
    }
    
    public boolean isPublicCalendar() {
        return publicCalendar;
    }

    public void setPublicCalendar(boolean publicCalendar) {
        this.publicCalendar = publicCalendar;
    }

    //////OVERRIDES
    
    @Override
    public String toString() {
        return mail;
    }

    
//    @XmlTransient
//    public Collection<Event> getEventCollection() {
//        return eventCollection;
//    }
//
//    public void setEventCollection(Collection<Event> eventCollection) {
//        this.eventCollection = eventCollection;
//    }

//    @XmlTransient
//    public Collection<Notification> getNotificationCollection() {
//        return notificationCollection;
//    }
//
//    public void setNotificationCollection(Collection<Notification> notificationCollection) {
//        this.notificationCollection = notificationCollection;
//    }
//
//    @XmlTransient
//    public Collection<Invitation> getInvitationCollection() {
//        return invitationCollection;
//    }
//
//    public void setInvitationCollection(Collection<Invitation> invitationCollection) {
//        this.invitationCollection = invitationCollection;
//    }
//
//    @XmlTransient
//    public Collection<Event> getEventCollection1() {
//        return eventCollection1;
//    }
//
//    public void setEventCollection1(Collection<Event> eventCollection1) {
//        this.eventCollection1 = eventCollection1;
//    }
//
//    public Calendar getCalendaridCalendar() {
//        return calendaridCalendar;
//    }
//
//    public void setCalendaridCalendar(Calendar calendaridCalendar) {
//        this.calendaridCalendar = calendaridCalendar;
//    }

//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (idUsers != null ? idUsers.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Users)) {
//            return false;
//        }
//        Users other = (Users) object;
//        if ((this.idUsers == null && other.idUsers != null) || (this.idUsers != null && !this.idUsers.equals(other.idUsers))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "MeteoCal.business.security.entity.Users[ idUsers=" + idUsers + " ]";
//    }
    
}
