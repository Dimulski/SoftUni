package problem18DepositsFilter;

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
                "SELECT w.depositGroup, SUM(w.depositAmount) AS tda " +
                "FROM WizzardDeposit AS w " +
                "WHERE w.magicWandCreator = 'Ollivander family' " +
                "GROUP BY w.depositGroup " +
                "HAVING SUM(w.depositAmount) < 150000 " +
                "ORDER BY tda DESC ").getResultList();

        for (Object[] depositGroupTotalDepositSum : resultList) {
            String depositGroupName = (String) depositGroupTotalDepositSum[0];
            BigDecimal sum = (BigDecimal) depositGroupTotalDepositSum[1];
            System.out.printf("%s - %.2f\n", depositGroupName, sum);
        }

        em.close();
        emf.close();
    }
}
