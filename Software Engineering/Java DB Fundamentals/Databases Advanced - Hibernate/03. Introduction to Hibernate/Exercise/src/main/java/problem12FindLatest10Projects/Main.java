package problem12FindLatest10Projects;

import entities.softuni.Project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        List<Project> projects = em.createQuery(
                "SELECT p FROM Project AS p " +
                "ORDER BY p.projectId DESC")
                .setMaxResults(10)
                .getResultList();

        projects.stream().sorted((p1, p2) -> p1.getName().compareTo(p2.getName()))
                .forEach(p -> System.out.printf(
                        "%s:\n%s\n%s - %s\n\n",
                        p.getName(),
                        p.getDescription(),
                        p.getStartDate(),
                        p.getEndDate()));

        em.close();
        emf.close();
    }
}
