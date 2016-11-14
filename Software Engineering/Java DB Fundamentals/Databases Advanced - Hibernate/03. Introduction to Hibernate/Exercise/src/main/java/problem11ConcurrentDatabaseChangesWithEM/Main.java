package problem11ConcurrentDatabaseChangesWithEM;

import entities.softuni.Employee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em1 = emf.createEntityManager();
        EntityManager em2 = emf.createEntityManager();

        em1.getTransaction().begin();
        Employee employee = em1.find(Employee.class, 1);
        em1.lock(employee, LockModeType.PESSIMISTIC_WRITE);
        employee.setFirstName("Pesho");

        em2.getTransaction().begin();
        em2.lock(employee, LockModeType.PESSIMISTIC_WRITE);
        employee.setFirstName("Gosho");

        em1.getTransaction().commit();
        em2.getTransaction().commit();

        em1.close();
        em2.close();
        emf.close();
    }
}
