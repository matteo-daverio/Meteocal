/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.business.security.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author DeMaria
 */
@Embeddable
public class EventPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "idEvent")
    private int idEvent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Users_idUsers")
    private int usersidUsers;

    public EventPK() {
    }

    public EventPK(int idEvent, int usersidUsers) {
        this.idEvent = idEvent;
        this.usersidUsers = usersidUsers;
    }

    public int getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(int idEvent) {
        this.idEvent = idEvent;
    }

    public int getUsersidUsers() {
        return usersidUsers;
    }

    public void setUsersidUsers(int usersidUsers) {
        this.usersidUsers = usersidUsers;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idEvent;
        hash += (int) usersidUsers;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventPK)) {
            return false;
        }
        EventPK other = (EventPK) object;
        if (this.idEvent != other.idEvent) {
            return false;
        }
        if (this.usersidUsers != other.usersidUsers) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "MeteoCal.business.security.entity.Event1PK[ idEvent=" + idEvent + ", usersidUsers=" + usersidUsers + " ]";
    }
    
}
