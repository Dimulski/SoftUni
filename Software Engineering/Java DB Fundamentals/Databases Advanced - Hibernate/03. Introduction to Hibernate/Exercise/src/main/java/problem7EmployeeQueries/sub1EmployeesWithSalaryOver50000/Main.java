package problem7EmployeeQueries.sub1EmployeesWithSalaryOver50000;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        em.createQuery("SELECT e.firstName FROM Employee AS e WHERE e.salary > 50000")
                .getResultList().forEach(System.out::println);

        em.close();
        emf.close();
    }
}
