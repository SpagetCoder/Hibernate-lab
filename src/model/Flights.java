/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author Luke
 */
@Entity
@Table(name="Flights")
public class Flights implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Flight_ID")
    private int id;
    private LocalDate date;
    private int hours;
    private String description;
        
    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name="FlightInstructor_ID",foreignKey = @javax.persistence.ForeignKey(name = "FK_Flight_FlightInstructor"))
    private FlightInstructor flightInstructor;
    
    
    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name="Student_ID",foreignKey = @javax.persistence.ForeignKey(name = "FK_Flight_Student"))
    private Student student;

    public Flights() {
    }

    public Flights(LocalDate date, int hours, String description) {
        this.date = date;
        this.hours = hours;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public FlightInstructor getFlightInstructor() {
        return flightInstructor;
    }

    public void setFlightInstructor(FlightInstructor flightInstructor) {
        this.flightInstructor = flightInstructor;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
    
    
    
    
}
