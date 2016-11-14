package problem8AddAddressUpdateEmployee;

import entities.softuni.Address;
import entities.softuni.Employee;
import entities.softuni.Town;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        Query townQuery = em.createQuery("SELECT t FROM Town AS t WHERE t.name = 'Sofia'");
        Town sofia = (Town) townQuery.getSingleResult();

        Address address = new Address();
        address.setAddressText("Vitoshka 15");
        address.setTown(sofia);
        em.persist(address);

        Query nakovQuery = em.createQuery("SELECT e FROM Employee AS e WHERE e.lastName = 'Nakov'");
        Employee nakov = (Employee) nakovQuery.getSingleResult();
        nakov.setAddress(address);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
