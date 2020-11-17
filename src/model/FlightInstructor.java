package model;

import goodies.BooleanConverter;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Luke
 */
@Entity
@PrimaryKeyJoinColumn(name = "FligthInstructor_ID", foreignKey = @javax.persistence.ForeignKey(name="FK_FligthInstructor_Person"))
@Table(name="FlightInstructors")
public class FlightInstructor extends Person implements Serializable
{
    private int licenceNo;
    @Convert(converter = BooleanConverter.class)
    private Boolean valid;
    
    @OneToMany(mappedBy = "flightInstructor")
    private Set<Flights> flights;

    public FlightInstructor() {
    }

    public FlightInstructor(int licenceNo, boolean valid, String fName, String sName, String snn) 
    {
        super(fName, sName, snn);
        this.licenceNo = licenceNo;
        this.valid = valid;
    } 

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }


    public int getLicenceNo() {
        return licenceNo;
    }

    public void setLicenceNo(int licenceNo) {
        this.licenceNo = licenceNo;
    }

    public Set<Flights> getFlights() {
        return flights;
    }

    public void setFlights(Set<Flights> flights) {
        this.flights = flights;
    }


  
}
