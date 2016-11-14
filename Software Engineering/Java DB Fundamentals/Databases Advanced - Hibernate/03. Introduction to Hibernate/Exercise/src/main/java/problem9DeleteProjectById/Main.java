package problem9DeleteProjectById;

import entities.softuni.Employee;
import entities.softuni.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Project targetProject = em.find(Project.class, 2);

        // We have to delete target project from each employee
        // that is assigned to it, since delete on cascade is disabled.
        List<Employee> employees = em.createQuery(
                "SELECT e FROM Employee AS e " +
                "INNER JOIN e.projects AS p " +
                "WHERE p.projectId = 2").getResultList();
        employees.forEach(e -> e.getProjects().remove(targetProject));

        em.remove(targetProject);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
