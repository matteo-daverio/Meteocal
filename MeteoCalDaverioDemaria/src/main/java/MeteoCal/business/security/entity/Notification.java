/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.business.security.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.validation.constraints.NotNull;


/**
 *
 * @author DeMaria
 */
@Entity
//@Table(name = "notification")

//@NamedQueries({
    //@NamedQuery(name= Users.findAll, query = "SELECT u FROM Users u"),
    //@NamedQuery(name= Users.count, query="SELECT count(u) FROM Users u"),

//})
public class Notification implements Serializable {
    private static final long serialVersionUID = 1L;
    
//    @Id
//    @Basic(optional = false)
//    @NotNull
//    @GeneratedValue(strategy=GenerationType.AUTO)//crea automaticamente un valore per questo attributo
//    @Column(name = "idNotification")
//    private Integer idNotification;
    
    @Id
    @NotNull
    @GeneratedValue(generator = "increment")
    private int idNotification;
    
    @ManyToOne(targetEntity = Event.class, optional = false, fetch = FetchType.EAGER)
    private Event event;

    @ManyToOne(targetEntity = Users.class, optional = false, fetch = FetchType.EAGER)
    private Users user;

    private boolean creator;

    private boolean accepted;

    private boolean view;

    
//    @Column(name = "date")
//    @Temporal(TemporalType.DATE)
//    private Date date;
    
//    @JoinColumn(name = "Event_idEvent", referencedColumnName = "idEvent")
//    @ManyToOne
//    private Event eventidEvent;
//    
//    @JoinColumn(name = "Users_idUsers", referencedColumnName = "idUsers")
//    @ManyToOne
//    private Users usersidUsers;

    ///COSTRUTTORI /////
    
    public Notification() {
    }

    
    public Notification(Event event, Users user, boolean creator) {
        this.event = event;
        this.user = user;
        this.creator = creator;
    }

    
//    public Notification(Integer idNotification) {
//        this.idNotification = idNotification;
//    }

    
    
  //GETTERS AND SETTERS
    
    public Integer getIdNotification() {
        return idNotification;
    }

    public void setIdNotification(Integer idNotification) {
        this.idNotification = idNotification;
    }
//
//    public Date getDate() {
//        return date;
//    }
//
//    public void setDate(Date date) {
//        this.date = date;
//    }
//
//    public Event getEventidEvent() {
//        return eventidEvent;
//    }
//
//    public void setEventidEvent(Event eventidEvent) {
//        this.eventidEvent = eventidEvent;
//    }
//
//    public Users getUsersidUsers() {
//        return usersidUsers;
//    }
//
//    public void setUsersidUsers(Users usersidUsers) {
//        this.usersidUsers = usersidUsers;
//    }

    
    public boolean isCreator() {
        return creator;
    }

    public void setCreator(boolean creator) {
        this.creator = creator;
    }

    public boolean isAccepted() {
        return accepted;
    }

    public void setAccepted(boolean accepted) {
        this.accepted = accepted;
    }

    public boolean isView() {
        return view;
    }

    public void setView(boolean view) {
        this.view = view;
    }

   public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

   //////////////////OVVERRIDES//////////////////////// 

    @Override
    public String toString() {
        return "MeteoCal.business.security.entity.Notification[ idNotification=" + idNotification + " ]";
    }
    
}
