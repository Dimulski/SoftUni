import entities.Town;
import javafx.scene.input.InputMethodTextRun;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by teodo on 28/10/2016.
 */
public class DemoQueries {
    public static void main(String[] args) {
        EntityManagerFactory emf
                = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

//        Query nativeQuery = em.createNativeQuery("SELECT * FROM towns AS t WHERE LENGTH(t.name) > 5");
//        List<Object[]> towns = nativeQuery.getResultList();
//
//        for (Object[] object : towns) {
//            int pk = (int) object[0];
//            Town town = em.find(Town.class,pk);
//            em.detach(town);
//            System.out.println(town.getName());
//        }

        Query jpqlQuery = em.createQuery("SELECT t FROM Town AS t " +
                "WHERE LENGTH(t.name) > 5");
        List<Town> towns = jpqlQuery.setMaxResults(5).getResultList();
        for (Town town : towns) {
            System.out.println(town.getName());
        }

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
