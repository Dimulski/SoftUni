package app.repositories;

import app.domain.WizardDeposit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;


@Repository
@Transactional
public interface WizardDepositRepository extends JpaRepository<WizardDeposit, Long> {

}
