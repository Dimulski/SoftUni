package problem16EmployeesMaximumSalaries;

import entities.softuni.Department;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        List<Object[]> resultList = em.createQuery(
                "SELECT d, MAX(e.salary) " +
                "FROM Department AS d " +
                "INNER JOIN d.employees AS e " +
                "GROUP BY d.departmentId " +
                "HAVING MAX(e.salary) NOT BETWEEN 30000 AND 70000")
                .getResultList();

        for (Object[] departmentMaxSalary : resultList) {
            Department department = (Department) departmentMaxSalary[0];
            BigDecimal maxSalary = (BigDecimal) departmentMaxSalary[1];
            System.out.printf("%s - %.2f\n", department.getName(), maxSalary);
        }

        em.close();
        emf.close();
    }
}
