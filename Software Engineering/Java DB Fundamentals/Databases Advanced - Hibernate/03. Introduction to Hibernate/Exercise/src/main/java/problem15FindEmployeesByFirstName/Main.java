package problem15FindEmployeesByFirstName;

import entities.softuni.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        String pattern = reader.readLine();
        List<Employee> employees = em.createQuery("SELECT e FROM Employee AS e WHERE e.firstName LIKE :pattern")
                .setParameter("pattern", pattern + "%").getResultList();

        employees.forEach(e -> System.out.printf(
                "%s %s - %s - ($%.2f)\n",
                e.getFirstName(),
                e.getLastName(),
                e.getJobTitle(),
                e.getSalary()));

        em.close();
        emf.close();
        reader.close();
    }
}
