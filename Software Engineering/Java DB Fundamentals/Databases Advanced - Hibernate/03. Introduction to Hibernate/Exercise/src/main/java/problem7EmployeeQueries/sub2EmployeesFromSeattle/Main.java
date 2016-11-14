package problem7EmployeeQueries.sub2EmployeesFromSeattle;

import entities.softuni.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        List<Employee> employees = em.createQuery(
                "SELECT e FROM Employee AS e " +
                "INNER JOIN e.department AS d " +
                "WHERE d.name = 'Research and Development' " +
                "ORDER BY e.salary ASC")
                .getResultList();

        employees.forEach(e -> System.out.printf(
                "%s %s from %s -$%.2f\n",
                e.getFirstName(),
                e.getLastName(),
                e.getDepartment(),
                e.getSalary()));

        em.close();
        emf.close();
    }
}
