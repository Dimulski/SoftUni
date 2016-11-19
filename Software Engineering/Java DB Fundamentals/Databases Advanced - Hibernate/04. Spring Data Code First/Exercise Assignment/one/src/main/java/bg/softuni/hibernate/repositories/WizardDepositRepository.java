package bg.softuni.hibernate.repositories;

import bg.softuni.hibernate.entities.WizardDeposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface WizardDepositRepository extends JpaRepository<WizardDeposit,Long> {

    @Override
    @Query("SELECT wd FROM WizardDeposit AS wd WHERE wd.isDepositExpired=false")
    List<WizardDeposit> findAll();
}
