package app.repositories;

import app.domain.Visitation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface VisitationRepository extends JpaRepository<Visitation, Long> {

}
