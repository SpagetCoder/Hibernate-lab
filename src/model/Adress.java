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
import javax.persistence.Table;

/**
 *
 * @author Luke
 */
@Entity 
@Table(name="Addresses")
public class Adress implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Address_ID")
    private int id;
    private String country;
    private String city;
    private String postalCode;
    private String street;
    
    @OneToMany(mappedBy = "address")
    private Set<Person> persons;
    
    public Adress(String country, String city, String postalCode, String street) {
        this.country = country;
        this.city = city;
        this.postalCode = postalCode;
        this.street = street;
    }
    
    public Adress()
    {
        
    }

    @Override
    public String toString() {
        return "Adresess{" + "country=" + country + ", city=" + city + ", postalCode=" + postalCode + ", street=" + street + '}';
    }
    

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setStreet(String street) {
        this.street = street;
    }
    
        public Set<Person> getPersons() {
        return persons;
    }

    public void setPersons(Set<Person> persons) {
        this.persons = persons;
    }    
}
