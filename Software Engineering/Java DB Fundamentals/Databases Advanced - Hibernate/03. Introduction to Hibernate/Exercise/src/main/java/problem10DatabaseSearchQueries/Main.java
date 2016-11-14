package problem10DatabaseSearchQueries;

import entities.softuni.Address;
import entities.softuni.Department;
import entities.softuni.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        StringBuilder result = new StringBuilder();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        // First Query
        // Note: By definition there must be at least one project starting in the target time period for given employee,
        // after which all projects of said employee are printed.
        List<Employee> employees = em.createQuery(
                "SELECT e FROM Employee AS e " +
                "INNER JOIN e.projects AS p " +
                "WHERE p.startDate >= '2001-01-01' AND p.startDate < '2004-01-01'")
                .getResultList();

        for (Employee e : employees) {
            result.append(String.format(
                    "Employee: %s %s\nManager: %s %s\nProjects:\n",
                    e.getFirstName(),
                    e.getLastName(),
                    e.getManager().getFirstName(),
                    e.getManager().getLastName()));

            e.getProjects().forEach(p -> result.append(String.format(
                    "\t%s: %s - %s\n",
                    p.getName(),
                    p.getStartDate(),
                    p.getEndDate())));
            result.append(System.lineSeparator());
        }
        System.out.println(result.toString());


        // Second Query
        List<Address> addresses = em.createQuery(
                "SELECT a FROM Employee AS e " +
                "INNER JOIN e.address AS a " +
                "GROUP BY a.addressId " +
                "ORDER BY COUNT(e) DESC")
                .setMaxResults(10)
                .getResultList();

        addresses.forEach(a -> System.out.printf(
                "%s, %s - %s employees\n",
                a.getAddressText(),
                a.getTown(),
                a.getEmployees().size()));


        //Third Query
        Employee employee = em.find(Employee.class, 147);
        System.out.printf(
                "%s %s - %s\nProjects:\n",
                employee.getFirstName(),
                employee.getLastName(),
                employee.getJobTitle());

        employee.getProjects()
                .stream()
                .sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                .forEach(p -> System.out.printf("\t%s\n", p.getName()));


        //Fourth Query
        List<Department> departments = em.createQuery(
                "SELECT d FROM Department AS d " +
                "WHERE d.employees.size > 5 " +
                "ORDER BY d.employees.size ASC")
                .getResultList();

        departments.forEach(d -> System.out.printf(
                "--%s - Manager: %s, Employees: %d\n",
                d.getName(),
                d.getManager().getLastName(),
                d.getEmployees().size()));

        em.close();
        emf.close();
    }
}
