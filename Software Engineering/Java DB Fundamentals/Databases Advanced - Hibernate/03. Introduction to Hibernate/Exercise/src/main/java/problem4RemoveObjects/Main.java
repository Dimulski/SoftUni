package problem4RemoveObjects;

import entities.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Query townsQuery = em.createQuery("SELECT t from Town as t");
        List<Town> towns = townsQuery.getResultList();

        towns.stream().filter(t -> t.getName().length() > 5).forEach(em::detach);

        towns.forEach(t -> t.setName(t.getName().toLowerCase()));

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
