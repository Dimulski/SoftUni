package problem19FirstLetter;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gringotts");
        EntityManager em = emf.createEntityManager();

        em.createQuery(
                "SELECT SUBSTRING(w.firstName, 1, 1) AS p " +
                "FROM WizzardDeposit AS w " +
                "WHERE w.depositGroup = 'Troll Chest' " +
                "GROUP BY SUBSTRING(w.firstName, 1, 1)")
                .getResultList()
                .forEach(System.out::println);

        em.close();
        emf.close();
    }
}
