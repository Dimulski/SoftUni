package problem17DepositsSumForOllivanderFamily;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gringotts");
        EntityManager em = emf.createEntityManager();

        List<Object[]> resultList = em.createQuery(
                "SELECT w.depositGroup, SUM(w.depositAmount) " +
                "FROM WizzardDeposit AS w " +
                "WHERE w.magicWandCreator = 'Ollivander family' " +
                "GROUP BY w.depositGroup")
                .getResultList();

        for (Object[] depositGroupSum : resultList) {
            String depositGroupName = (String) depositGroupSum[0];
            BigDecimal sum = (BigDecimal) depositGroupSum[1];
            System.out.printf("%s - %.2f\n", depositGroupName, sum);
        }

        em.close();
        emf.close();
    }
}
