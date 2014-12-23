/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.business.security.entity;

import MeteoCal.businness.security.control.PasswordEncrypter;
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
    @NamedQuery(name = "Users1.findAll", query = "SELECT u FROM Users1 u"),
    @NamedQuery(name = "Users1.findByIdUsers", query = "SELECT u FROM Users1 u WHERE u.users1PK.idUsers = :idUsers"),
    @NamedQuery(name = "Users1.findByName", query = "SELECT u FROM Users1 u WHERE u.name = :name"),
    @NamedQuery(name = "Users1.findBySurname", query = "SELECT u FROM Users1 u WHERE u.surname = :surname"),
    @NamedQuery(name = "Users1.findByMail", query = "SELECT u FROM Users1 u WHERE u.mail = :mail"),
    @NamedQuery(name = "Users1.findByPsw", query = "SELECT u FROM Users1 u WHERE u.psw = :psw"),
    @NamedQuery(name = "Users1.findByCalendaridCalendar", query = "SELECT u FROM Users1 u WHERE u.users1PK.calendaridCalendar = :calendaridCalendar")})
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsersPK users1PK;
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
    @ManyToMany(mappedBy = "users1Collection")
    private Collection<Event> event1Collection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users1")
    private Collection<Notification> notification1Collection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users1")
    private Collection<Invitation> invitation1Collection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "users1")
    private Collection<Event> event1Collection1;
    @JoinColumn(name = "Calendar_idCalendar", referencedColumnName = "idCalendar", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Calendar calendar1;

    public Users() {
    }

    public Users(UsersPK users1PK) {
        this.users1PK = users1PK;
    }

    public Users(int idUsers, int calendaridCalendar) {
        this.users1PK = new UsersPK(idUsers, calendaridCalendar);
    }

    public UsersPK getUsers1PK() {
        return users1PK;
    }

    public void setUsers1PK(UsersPK users1PK) {
        this.users1PK = users1PK;
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
        this.psw = PasswordEncrypter.encryptPassword(psw);
    }

    @XmlTransient
    public Collection<Event> getEvent1Collection() {
        return event1Collection;
    }

    public void setEvent1Collection(Collection<Event> event1Collection) {
        this.event1Collection = event1Collection;
    }

    @XmlTransient
    public Collection<Notification> getNotification1Collection() {
        return notification1Collection;
    }

    public void setNotification1Collection(Collection<Notification> notification1Collection) {
        this.notification1Collection = notification1Collection;
    }

    @XmlTransient
    public Collection<Invitation> getInvitation1Collection() {
        return invitation1Collection;
    }

    public void setInvitation1Collection(Collection<Invitation> invitation1Collection) {
        this.invitation1Collection = invitation1Collection;
    }

    @XmlTransient
    public Collection<Event> getEvent1Collection1() {
        return event1Collection1;
    }

    public void setEvent1Collection1(Collection<Event> event1Collection1) {
        this.event1Collection1 = event1Collection1;
    }

    public Calendar getCalendar1() {
        return calendar1;
    }

    public void setCalendar1(Calendar calendar1) {
        this.calendar1 = calendar1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (users1PK != null ? users1PK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Users)) {
            return false;
        }
        Users other = (Users) object;
        if ((this.users1PK == null && other.users1PK != null) || (this.users1PK != null && !this.users1PK.equals(other.users1PK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MeteoCal.business.security.entity.Users1[ users1PK=" + users1PK + " ]";
    }
    
}
