package problem5ContainsEmployee;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("soft_uni");
        EntityManager em = emf.createEntityManager();

        List<String> employeeName = new ArrayList<>(Arrays.asList(reader.readLine().split("\\s+")));

        List filteredEmployees = em.createQuery(
                "SELECT e FROM Employee AS e " +
                "WHERE CONCAT(e.firstName, ' ', e.lastName) = :employeeName").setParameter("employeeName",
                employeeName.get(0) + " " + (employeeName.size() == 3? employeeName.get(2) : employeeName.get(1)))
                .getResultList();

        System.out.println(filteredEmployees.size() > 0? "Yes" : "No");

        em.close();
        emf.close();
    }
}
