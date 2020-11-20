/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hiberApp;

import util.HiberUtil;
import org.hibernate.SessionFactory;

/* 
 @author LabHiber
 */
public final class MainApp {

//      private static final SessionFactory SESSION_FACTORY = HiberUtil.getSessionFactory(HiberUtil.Mapping.XML);
      private static final SessionFactory SESSION_FACTORY = HiberUtil.getSessionFactory(HiberUtil.Mapping.ANN);

    public static void main(String[] args) {
        
                final DataLoad dataLoad = new DataLoad();
                dataLoad.createData(SESSION_FACTORY);
                final DataQueries dataQueries = new DataQueries();
                
                System.out.println("==========Implicite JPQL==========\n");
                dataQueries.impliciteJPQL(SESSION_FACTORY);
                System.out.println("\n==========Explicite JPQL==========\n");
                dataQueries.expliciteJPQL(SESSION_FACTORY);
                System.out.println("\n==========Simple JPQL==========\n");
                dataQueries.simpleJPQL(SESSION_FACTORY);
                System.out.println("\n==========Aggregation JPQL==========\n");
                dataQueries.aggregationJPGL(SESSION_FACTORY);                             
                System.out.println("\n==========Aggregation criteria==========\n");
                dataQueries.aggregationCriteria(SESSION_FACTORY);
                System.out.println("\n==========Explicite Criteria==========\n");
                dataQueries.expliciteCriteria(SESSION_FACTORY);
                System.out.println("\n==========Implicite Criteria==========\n");
                dataQueries.impliciteCriteria(SESSION_FACTORY);
                System.out.println("\n==========Simple Criteria==========\n");
                dataQueries.simpleCriteria(SESSION_FACTORY);
       
    }
}
