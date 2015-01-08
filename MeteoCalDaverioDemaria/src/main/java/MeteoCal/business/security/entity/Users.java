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
@NamedQueries({
    @NamedQuery(name = "Users.findAll", query = "SELECT u FROM Users u"),
    @NamedQuery(name = "Users.findByIdUsers", query = "SELECT u FROM Users u WHERE u.idUsers = :idUsers"),
    @NamedQuery(name = "Users.findByName", query = "SELECT u FROM Users u WHERE u.name = :name"),
    @NamedQuery(name = "Users.findBySurname", query = "SELECT u FROM Users u WHERE u.surname = :surname"),
    @NamedQuery(name = "Users.findByMail", query = "SELECT u FROM Users u WHERE u.mail = :mail"),
    @NamedQuery(name = "Users.findByPsw", query = "SELECT u FROM Users u WHERE u.psw = :psw")})
public class Users implements Serializable {
    private static final long serialVersionUID = 1L;
    
    //DEFINIZIONE COLONNE
    
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idUsers")
    private Integer idUsers;
    
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
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usersidUsers")
    private Collection<Event> eventCollection1;
    
    //FOREIGN KEY
    
    @JoinColumn(name = "Calendar_idCalendar", referencedColumnName = "idCalendar")
    @ManyToOne(optional = false)
    private Calendar calendaridCalendar;

    //costruttori
    
    public Users() {
    }

    public Users(Integer idUsers) {
        this.idUsers = idUsers;
    }

    
    //getters and setters
    
    public Integer getIdUsers() {
        return idUsers;
    }

    public void setIdUsers(Integer idUsers) {
        this.idUsers = idUsers;
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
