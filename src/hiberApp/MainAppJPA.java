/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hiberApp;

import util.EMBuilder;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Tuple;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;
import model.Person;
import model.Person_;


/* 
 @author LabHiber
 */
public final class MainAppJPA {

    private final static EntityManagerFactory FACTORY = Persistence.createEntityManagerFactory("labPU");

    public static void main(String[] args) {
        //showAllPersons();
        EMBuilder.closeFactory();

    }

    public static void showAllPersons() {
        EntityManager em = EMBuilder.getEM();
        List<Person> result = em.createQuery("select e from Employee e").getResultList();
        result.forEach(System.out::println);       
        System.out.println("=======================");
        
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery criteria = builder.createQuery(Person.class);
        Root<Person> root = criteria.from(Person.class);
        criteria.select(root);
        result = em.createQuery(criteria).getResultList();
        result.forEach(System.out::println);
        
        builder = em.getCriteriaBuilder();
        criteria = builder.createQuery(String.class);
        root = criteria.from(Person.class);
        criteria.select(root.get(Person_.S_NAME));
        List<String> names = em.createQuery(criteria).getResultList();
        names.forEach(System.out::println);
        em.close();
    }
   
}
