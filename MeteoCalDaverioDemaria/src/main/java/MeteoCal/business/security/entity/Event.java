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
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author DeMaria
 */
@Entity
public class Event implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Id
    @OneToOne
    private IDEvent idEvent;

 
    private Boolean pubblico;
    

    private String title;
    

    @NotNull(message = "May not be empty6")
    @ManyToOne(targetEntity = Place.class, optional = false, cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
    private Place place = new Place();

    
    private Boolean outdoor;
    
    private Timestamp startTime;
    
    private Timestamp endTime;
    
   
    @Temporal(TemporalType.DATE)
    private Date date;
   
    private String description;
    
    @NotNull(message = "May not be empty1")
    @ManyToOne(targetEntity = Users.class, optional = false)
    private Users creator;
    
    
  ////////COSTRUTTORI
    
    public Event() {
    }

    public Event(IDEvent idEvent) {
        this.idEvent = idEvent;
    }

   /////GETTERS AND SETTERS 
    
    public IDEvent getIdEvent() {
        return idEvent;
    }

    public void setIdEvent(IDEvent idEvent) {
        this.idEvent = idEvent;
    }

    public Boolean isPubblico() {
        return pubblico;
    }

    public void setPubblico(Boolean pubblico) {
        this.pubblico = pubblico;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place Place) {
        this.place = Place;
    }


    public Boolean isOutdoor() {
        return outdoor;
    }

    public void setOutdoor(Boolean outdoor) {
        this.outdoor = outdoor;
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
        this.outdoor = e.isOutdoor();
        this.place = new Place(e.getPlace());
        this.pubblico = e.isPublicEvent();
        this.startTime = e.getStartDate();
        this.endTime = e.getEndDate();
    }

 ////OVERRIDES

    @Override
    public String toString() {
        return "MeteoCal.business.security.entity.Event[ idEvent=" + idEvent + " ]";
    }
    
}
