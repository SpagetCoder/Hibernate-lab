/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author Luke
 */
@Entity
@PrimaryKeyJoinColumn(name = "Student_ID", foreignKey = @javax.persistence.ForeignKey(name="FK_Students_Person"))
@Table(name="Students")
public class Student extends Person implements Serializable
{
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(name="Student_Theory_Classes",
        joinColumns=@JoinColumn(name="Student_ID"),
        inverseJoinColumns=@JoinColumn(name="TheoryClasses_ID"),
        foreignKey = @javax.persistence.ForeignKey(name="FK_Student_TheoryClasses"), 
        inverseForeignKey = @javax.persistence.ForeignKey(name="FK_TheoryClasses_Student"))
    private Set<TheoryClasses> theoryClasses;
    
    @OneToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name="Student_ID",
        foreignKey = @javax.persistence.ForeignKey(name = "FK_Flight_Student"))
    private Set<Flights> flights;
        
    @ManyToMany
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinTable(name="Student_Courses",
        joinColumns=@JoinColumn(name="Student_ID"),
        inverseJoinColumns=@JoinColumn(name="Course_ID"),
        foreignKey = @javax.persistence.ForeignKey(name="FK_Course_Student"), 
        inverseForeignKey = @javax.persistence.ForeignKey(name="FK_Student_Course"))
    private Set<Course> courses;
    
    private String medicalTest;

    public Student() {
    }

    public Student(String fName, String sName, String ssn) 
    {
        super(fName, sName, ssn);
    }

    public Set<TheoryClasses> getTheoryClasses() {
        return theoryClasses;
    }

    public void setTheoryClasses(Set<TheoryClasses> theoryClasses) {
        this.theoryClasses = theoryClasses;
    }

    public Set<Flights> getFlights() {
        return flights;
    }

    public void setFlights(Set<Flights> flights) {
        this.flights = flights;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public String getMedicalTest() {
        return medicalTest;
    }

    public void setMedicalTest(String medicalTest) {
        this.medicalTest = medicalTest;
    }
      
}
