/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MeteoCal.business.security.entity;

import MeteoCal.business.security.EventCreator;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author DeMaria
 */
@Entity
//@Table(name = "event")

//@NamedQueries({
    //@NamedQuery(name= Users.findAll, query = "SELECT u FROM Users u"),
    //@NamedQuery(name= Users.count, query="SELECT count(u) FROM Users u"),

//})
public class Event implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @Basic(optional = false)
    @NotNull
    @GeneratedValue(strategy=GenerationType.AUTO)//crea automaticamente un valore per questo attributo
   // @Column(name = "idEvent")
    private Integer idEvent;
    
    //@Column(name = "isPublic")
    private Boolean isPublic;
    
    //@Column(name="title")
    private String title;
    
    //@Size(max = 45)
    //@Column(name = "place")
    @NotNull(message = "May not be empty6")
    @ManyToOne(targetEntity = Place.class, optional = false, cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    private Place place = new Place();

    
    //@Column(name = "isOutdoor")
    private Boolean isOutdoor;
    
    //@Size(max = 45)
    //@Column(name = "weather")
    private String weather;
    
    //@Column(name = "startTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp startTime;
    
    //@Column(name = "endTime")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp endTime;
    
    //@Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    
    //@Column(name ="description")
    private String description;
    
    @NotNull(message = "May not be empty1")
    @ManyToOne(targetEntity = Users.class, optional = false)
    private Users creator;
    
//    @ManyToMany(mappedBy = "eventCollection")
//    private Collection<Users> usersCollection;
//    
//    @ManyToMany(mappedBy = "eventCollection")
//    private Collection<Calendar> calendarCollection;
//    
//    @OneToMany(mappedBy = "eventidEvent")
//    private Collection<Notification> notificationCollection;
//    
//    @OneToMany(mappedBy = "eventidEvent")
//    private Collection<Invitation> invitationCollection;
    
    //@JoinColumn(name = "Users_idUsers", referencedColumnName = "idUsers")
//    @NotNull
//    @ManyToOne(targetEntity = Users.class,optional = false)
//    private Users creator;

    
  ////////COSTRUTTORI
    
    public Event() {
    }

    public Event(Integer idEvent) {
        this.idEvent = idEvent;
    }

   /////GETTERS AND SETTERS 
    
    public Integer getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(Integer idEvent) {
        this.idEvent = idEvent;
    }

    public Boolean isPublic() {
        return isPublic;
    }

    public void setIsPublic(Boolean isPublic) {
        this.isPublic = isPublic;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place Place) {
        this.place = Place;
    }


    public Boolean isOutdoor() {
        return isOutdoor;
    }

    public void setIsOutdoor(Boolean isOutdoor) {
        this.isOutdoor = isOutdoor;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    
    public String getTitle() {       
        return title;
    }

    public void setTitle(String Title) {
        this.title = Title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    public Users getCreator() {
        return creator;
    }

    public void setCreator(Users creator) {
        this.creator = creator;
    }
    
    /**
     * convert date in Timestamp
     *
     * @param date
     */
    public void convertStartDate(Date date) {
        startTime = new java.sql.Timestamp(date.getTime());
    }

    /**
     * convert date in Timestamp
     *
     * @param date
     */
    public void convertEndDate(Date date) {
        endTime = new java.sql.Timestamp(date.getTime());
    }

    public void loadEvent(EventCreator e) {
        this.title = e.getTitle();
        this.creator = e.getCreator();
        this.description = e.getDescription();
        this.idEvent = e.getIdEvent();
        this.isOutdoor = e.isOutdoor();
        this.place = new Place(e.getPlace());
        this.isPublic = e.isPublicEvent();
        this.startTime = e.getStartDate();
        this.endTime = e.getEndDate();
    }

//    @XmlTransient
//    public Collection<Users> getUsersCollection() {
//        return usersCollection;
//    }
//
//    public void setUsersCollection(Collection<Users> usersCollection) {
//        this.usersCollection = usersCollection;
//    }
//
//    @XmlTransient
//    public Collection<Calendar> getCalendarCollection() {
//        return calendarCollection;
//    }
//
//    public void setCalendarCollection(Collection<Calendar> calendarCollection) {
//        this.calendarCollection = calendarCollection;
//    }
//
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
//    public Users getCreator() {
//        return creator;
//    }
//
//    public void setCreator(Users creator) {
//        this.creator = creator;
//    }

 ////OVERRIDES

    @Override
    public String toString() {
        return "MeteoCal.business.security.entity.Event[ idEvent=" + idEvent + " ]";
    }
    
}
