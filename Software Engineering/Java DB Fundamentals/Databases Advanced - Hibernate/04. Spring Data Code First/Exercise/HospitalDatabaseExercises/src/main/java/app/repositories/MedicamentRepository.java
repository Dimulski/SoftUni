package app.repositories;

import app.domain.Medicament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface MedicamentRepository extends JpaRepository<Medicament, Long> {

}
