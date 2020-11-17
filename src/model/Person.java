/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;

/**
 *
 * @author Luke
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
@Table(name="Persons")
public class Person implements Serializable
{
    @Id
    @Column(name = "Person_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
     
    private String fName;
    private String sName;
    private String ssn;
    
    @ManyToOne
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name="Adress_ID", foreignKey = @javax.persistence.ForeignKey(name = "FK_Addres"))
    private Adress adress;

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
    
    public Person() 
    {
        
    }

    public Person(String fName, String sName, String ssn) 
    {
        this.fName = fName;
        this.sName = sName;
        this.ssn = ssn;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }
   
    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }
      
    
}
