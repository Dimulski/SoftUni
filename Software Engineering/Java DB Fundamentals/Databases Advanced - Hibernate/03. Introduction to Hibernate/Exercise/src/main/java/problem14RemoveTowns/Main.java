package problem14RemoveTowns;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        em.createQuery("SELECT a FROM Address AS a WHERE a.town.name = 'Sofia'").getResultList().forEach(em::remove);

        em.remove(em.createQuery("SELECT t FROM Town AS t WHERE t.name = 'Sofia'").getSingleResult());

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
