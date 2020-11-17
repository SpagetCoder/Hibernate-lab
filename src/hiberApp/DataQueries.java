/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hiberApp;

import model.*;
import java.util.List;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Root;
import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/* 
 @author LabHiber
 */
public final class DataQueries {

    /**
     * Queries test data
     *
     * @param SESSION_FACTORY for connecting data source
     */
    
    public void showPersons(SessionFactory SESSION_FACTORY) {
        try (Session session = SESSION_FACTORY.openSession()) {
            Query query = session.createQuery("select p from Person p");
            List<Person> persons = query.list();
            persons.stream().forEach((person) -> {
                System.out.println(person.getfName() + " " + person.getsName()
                        + " " + person.getSsn());
            });
        }
    }

    public void simpleJPQL(SessionFactory SESSION_FACTORY) 
    {
        try (Session session = SESSION_FACTORY.openSession()) 
        {
            Query query = session.createQuery("select p.fName, p.sName from Person p where p.id = 3", Tuple.class);
            List<Tuple> result = query.getResultList();
            result.forEach(t -> {System.out.println(t.get(0) + " " + t.get(1));
            });

        }
    }

    public void explicitJPQL(SessionFactory SESSION_FACTORY) {

        try (Session session = SESSION_FACTORY.openSession()) {
            Query query = session.createQuery("select fi.fName, fi.sName, fi.ssn, f.date from FlightInstructor fi join Flights f on fi.id = f.id", Tuple.class);
            List<Tuple> result = query.getResultList();
            result.forEach(t -> {System.out.println(t.get(0) + " " + t.get(1) + " " + t.get(2) + " " + t.get(3) + " (date of flight)");
            });
        }
    }

    public void implicitJPQL(SessionFactory SESSION_FACTORY) {

        try (Session session = SESSION_FACTORY.openSession()) {

            Query query = session.createQuery("select a.city, a.street, a.postalCode from Adress a where a.country like 'Germany'", Tuple.class);
            List<Tuple> result = query.getResultList();
            result.forEach(t -> {System.out.println(t.get(0) + " " + t.get(1) + " " + t.get(2));
            });

        }
    }

    public void aggregationJPGL(SessionFactory SESSION_FACTORY) 
    {
        try (Session session = SESSION_FACTORY.openSession()) 
        {
            Query query = session.createQuery("select a.country, a.city, a.street from Adress a group by a.country, a.city, a.street", Tuple.class);
            List<Tuple> result = query.getResultList();
            result.forEach(t -> {System.out.println(t.get(0) + " " + t.get(1) + " " + t.get(2));
            });    
        }
    }
    
    public void aggregationCriteria(SessionFactory SESSION_FACTORY) 
    {

        try (Session session = SESSION_FACTORY.openSession())
        {
            CriteriaBuilder builder = SESSION_FACTORY.getCriteriaBuilder();
            CriteriaQuery query = builder.createTupleQuery();
            Root<Adress> root = query.from(Adress.class);

            query.multiselect(
                    root.get(Adress_.country),
                    root.get(Adress_.city),
                    root.get(Adress_.street),
                    builder.count(root)
            );
            query.groupBy(root.get(Adress_.country),
                    root.get(Adress_.city),
                    root.get(Adress_.street));

            List<Tuple> result = session
                    .createQuery(query)
                    .getResultList();
            result.forEach(t -> { System.out.println(t.get(0) + " " + t.get(1) + " " + t.get(2));
            });
        }
    }

    public void explicitCriteria(SessionFactory SESSION_FACTORY)
    {
        try (Session session = SESSION_FACTORY.openSession())
        {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery query = builder.createTupleQuery();
            Root<FlightInstructor> root = query.from(FlightInstructor.class);
            Join<FlightInstructor, Flights> flightsJoin = root.join(FlightInstructor_.flights);
            query.multiselect(
                    root.get(FlightInstructor_.fName),
                    root.get(FlightInstructor_.sName),
                    root.get(FlightInstructor_.ssn),
                    flightsJoin.get(Flights_.date)
            );
            List<Tuple> result = session.createQuery(query).getResultList();
            result.forEach(t -> { System.out.println(t.get(0) + " " + t.get(1) 
                    + " " + t.get(2) +  " - " + t.get(3) + " (date of flight)");
            });
        }
    }

    public void implicitCriteria(SessionFactory SESSION_FACTORY) 
    {
        try (Session session = SESSION_FACTORY.openSession()) 
        {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery query = builder.createTupleQuery();           
            Root<Adress> root = query.from(Adress.class);
            
            query.multiselect(
                    root.get(Adress_.city),
                    root.get(Adress_.street),
                    root.get(Adress_.postalCode)
            );
            query.where(builder.equal(root.get(Adress_.COUNTRY), ("Germany")));
            List<Tuple> result = session.createQuery(query)
                    .getResultList();
            result.forEach(t -> { System.out.println(t.get(0) + " " + t.get(1) + " " + t.get(2));
            });
        }
    }
    
    public void simpleCriteria(SessionFactory SESSION_FACTORY) 
    {
        try (Session session = SESSION_FACTORY.openSession()) 
        {
            CriteriaBuilder builder = session.getCriteriaBuilder();
            CriteriaQuery query = builder.createTupleQuery();
            Root<Person> root = query.from(Person.class);
            query.multiselect(
                    root.get(Person_.fName),
                    root.get(Person_.sName),
                    root.get(Person_.ssn)
            );
            query.where(builder.equal(root.get(Student_.id), "3"));
            List<Tuple> result = session.createQuery(query)
                    .getResultList();
            result.forEach(t -> {System.out.println(t.get(0) + " " + t.get(1) + " " + t.get(2));
            });
        }
    }   
}
