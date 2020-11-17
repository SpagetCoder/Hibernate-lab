/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hiberApp;

import com.sun.corba.se.spi.orb.ParserData;
import java.time.LocalDate;
import model.*;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* 
 @author LabHiber
 */
public final class DataLoad {

    /**
     * Creates test data
     *
     * @param SESSION_FACTORY for connecting data source
     */
    
    static Logger log = LoggerFactory.getLogger(DataLoad.class);
    protected void createData(SessionFactory SESSION_FACTORY) {
 
        try (Session session = SESSION_FACTORY.openSession()) {

            Transaction tx = null;
            try {
                log.trace("insert person transaction begin");
                tx = session.beginTransaction();
                Person person1 = new Person("John", "Carpenter", "49102797331");
                session.save(person1);
                Person person2 = new Person("Agnes", "Brut", "70061038326");
                session.save(person2);
                tx.commit();
                log.trace("insert person transaction commit");
            } catch (Exception e) {
                if (tx != null) {
                    tx.rollback();
                    log.trace(e.toString()); 
                }
            }    
                tx = session.beginTransaction();
         
                Course c1 = new Course("Private Pilot", LocalDate.parse("2020-10-20"),LocalDate.parse("2020-12-27"),
                        "Graduate will be allowed to be a private pilot after completing this course");
                session.save(c1);
                
                Course c2 = new Course("Commercial Pilot", LocalDate.parse("2020-10-20"),LocalDate.parse("2021-04-14"),
                        "Graduate will be allowed to be a Commercial Pilot after completing this course");
                session.save(c2);
                        
                Course c3 = new Course("Multi-Crew Pilot", LocalDate.parse("2020-10-22"),LocalDate.parse("2020-12-30"),
                        "Graduate will be allowed to be a Multi-Crew Pilot after completing this course");
                session.save(c3);
                
                Course c4 = new Course("Airline Transport Pilot", LocalDate.parse("2020-10-25"),LocalDate.parse("2021-02-21"),
                        "Graduate will be allowed to be a private pilot after completing this course");
                session.save(c4);
                
                Course c5 = new Course("Sport Pilot", LocalDate.parse("2020-11-20"),LocalDate.parse("2021-01-27"),
                        "Graduate will be allowed to be a Sport Pilot after completing this course");
                session.save(c5);
                
                Course c6 = new Course("Recreational pilot", LocalDate.parse("2020-12-25"),LocalDate.parse("2021-01-24"),
                        "Graduate will be allowed to be a Recreational pilot after completing this course");                                                      
                 session.save(c6);                           
                
                Set<Course> courses1 = new HashSet<>();
                Set<Course> courses2 = new HashSet<>();
                Set<Course> courses3 = new HashSet<>();
                Set<Course> courses4 = new HashSet<>();
                              
                courses1.add(c2);
                courses1.add(c1); 
                courses2.add(c6);
                courses3.add(c3);
                courses3.add(c4);
                courses4.add(c5);
                courses4.add(c6);
                
                
                TheoryClasses theory1 = new TheoryClasses("Physics", 20, 8);
                session.save(theory1);
                
                TheoryClasses theory2 = new TheoryClasses("Landing of the plane", 30, 12);
                session.save(theory2);
                
                TheoryClasses theory3 = new TheoryClasses("Weather conditions", 15, 10);
                session.save(theory3);
                
                TheoryClasses theory4 = new TheoryClasses("Emergency landing",30,15);
                session.save(theory4);
                
                TheoryClasses theory5 = new TheoryClasses("Geography",15,8);                          
                session.save(theory5);
                
                TheoryClasses theory6 = new TheoryClasses("Mathematics",15,8);                          
                session.save(theory6);
                
                Set<TheoryClasses> theoryClasseses1 = new HashSet<>();
                Set<TheoryClasses> theoryClasseses2 = new HashSet<>();
                Set<TheoryClasses> theoryClasseses3 = new HashSet<>();
                Set<TheoryClasses> theoryClasseses4 = new HashSet<>();
                
                
                theoryClasseses1.add(theory1);
                theoryClasseses1.add(theory2);
                theoryClasseses1.add(theory3);
                theoryClasseses1.add(theory4);
                theoryClasseses1.add(theory5);
                theoryClasseses1.add(theory6);
                theoryClasseses2.add(theory3);
                theoryClasseses2.add(theory4);
                theoryClasseses3.add(theory2);
                theoryClasseses3.add(theory4);
                theoryClasseses4.add(theory4);
                

                Flights f1 = new Flights(LocalDate.parse("2021-04-16"), 3, "Exam");                
                session.save(f1);
                
                Flights f2 = new Flights(LocalDate.parse("2021-01-26"), 4, "Exam");                
                session.save(f2);
                
                Flights f3 = new Flights(LocalDate.parse("2021-02-24"), 2, "Exam");                
                session.save(f3);
                
                Flights f4 = new Flights(LocalDate.parse("2021-01-27"), 2, "Exam");                
                session.save(f4);
                
                Flights f5 = new Flights(LocalDate.parse("2021-01-28"), 2, "Exam");                
                session.save(f5);
                
                Flights f6 = new Flights(LocalDate.parse("2020-12-10"), 2, "Practice flight");                
                session.save(f6);
                
                Flights f7 = new Flights(LocalDate.parse("2020-12-10"), 3, "Practice flight");                
                session.save(f7);
                
                Flights f8 = new Flights(LocalDate.parse("2020-11-29"), 5, "Practice flight");                
                session.save(f8);
                
                Flights f9 = new Flights(LocalDate.parse("2020-12-01"), 2, "Practice flight");                
                session.save(f9);
                
                Set<Flights> flights1 = new HashSet<>();
                Set<Flights> flights2 = new HashSet<>();
                Set<Flights> flights3 = new HashSet<>();
                Set<Flights> flights4 = new HashSet<>();
                
                
                flights1.add(f8);
                flights1.add(f1);
                
                flights2.add(f9);
                flights2.add(f2);
                
                flights3.add(f7);
                flights3.add(f3);
                
                flights4.add(f6);
                flights4.add(f4);
                flights4.add(f5);
                
                FlightInstructor flightInstructor1 = new FlightInstructor(335, true, "Arnold", "Schwarzenegger", "89506287491");
                flightInstructor1.setFlights(flights1);
                Adress a1 = new Adress("Poland", "Gliwice","44-103", "Zawodna 65");
                flightInstructor1.setAdress(a1);
                session.save(flightInstructor1);
                  
                FlightInstructor flightInstructor2 = new FlightInstructor(442, true, "John", "Emerald", "65506276491");
                flightInstructor2.setFlights(flights2);
                Adress a2 = new Adress("Poland", "Gliwice","44-103", "Okragla 36");
                flightInstructor2.setAdress(a2);
                session.save(flightInstructor2);
                
                FlightInstructor flightInstructor3 = new FlightInstructor(699, true, "Kate", "Smith", "89506287491");
                flightInstructor3.setFlights(flights3);
                Adress a3 = new Adress("Poland", "Gliwice","44-103", "Mikolaja Kopernika 3");
                flightInstructor3.setAdress(a3);
                session.save(flightInstructor3);
                
                FlightInstructor flightInstructor4 = new FlightInstructor(563, true, "Thomas", "Gibas", "82206282221");
                flightInstructor4.setFlights(flights4);
                Adress a4 = new Adress("Poland", "Gliwice","44-103", "Mikolaja Kopernika 7");
                flightInstructor4.setAdress(a4);
                session.save(flightInstructor4);
                                                                             
                                             
                Student student1 = new Student("Adrian", "Wolny", "75102357491"); 
                Adress a5 = new Adress("United States", "New York","BD8 9QR", "Washington Street");
                student1.setAdress(a5);
                student1.setMedicalTest("Hearing and eye examination");
                student1.setCourses(courses1);
                student1.setTheoryClasses(theoryClasseses1);
                student1.setFlights(flights1);
                session.save(student1);
                                
                Student student2 = new Student("Olgierd", "von Everec", "77011864512"); 
                Adress a6 = new Adress("Poland", "Gliwice","44-103", "Zawodna 5");
                student2.setAdress(a6);
                student2.setMedicalTest("Eye examination");
                student2.setCourses(courses2);
                student2.setTheoryClasses(theoryClasseses2);
                student2.setFlights(flights2);
                session.save(student2);
                
                Student student3 = new Student("Curt", "von Jungingen", "756102123491"); 
                Adress a7 = new Adress("Germany", "Hamburg","20095", "WonderWaffel");
                student3.setAdress(a7);
                student3.setMedicalTest("Hearing");
                student3.setCourses(courses3);
                student3.setTheoryClasses(theoryClasseses3);
                student3.setFlights(flights3);
                session.save(student3);
                
                Student student4 = new Student("Micheal", "Bay", "75611234491"); 
                Adress a8 = new Adress("United States", "New York","BD8 9QR", "Hamerican Street");
                student4.setAdress(a8);
                student4.setMedicalTest("Psyhological check");
                student4.setCourses(courses4);
                student4.setTheoryClasses(theoryClasseses4);    
                student4.setFlights(flights4);
                session.save(student4);
                
                
                f1.setStudent(student1);
                f1.setFlightInstructor(flightInstructor1);
                
                f2.setStudent(student2);
                f2.setFlightInstructor(flightInstructor2);
                
                f3.setStudent(student3);
                f3.setFlightInstructor(flightInstructor3);
                
                f4.setStudent(student4);
                f4.setFlightInstructor(flightInstructor4);
                
                f5.setStudent(student4);
                f5.setFlightInstructor(flightInstructor4);
                
                f6.setStudent(student4);
                f6.setFlightInstructor(flightInstructor4);
                
                f7.setStudent(student3);
                f7.setFlightInstructor(flightInstructor3);
                
                f8.setStudent(student1);
                f8.setFlightInstructor(flightInstructor1);
                
                f9.setStudent(student2);
                f9.setFlightInstructor(flightInstructor2);
                          
                
                tx.commit();
            }

        }
}
