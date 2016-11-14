package problem13IncreaseSalaries;

import entities.softuni.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        List<Employee> targetEmployees = em.createQuery(
                "SELECT e FROM Employee AS e " +
                "WHERE e.department.name IN " +
                "('Engineering', 'Tool Design', 'Marketing', 'Information Services')")
                .getResultList();

        targetEmployees.forEach(
                e -> {e.setSalary(e.getSalary().multiply(BigDecimal.valueOf(1.12)));
                      System.out.printf("%s %s ($%.2f)\n", e.getFirstName(), e.getLastName(), e.getSalary());});

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
