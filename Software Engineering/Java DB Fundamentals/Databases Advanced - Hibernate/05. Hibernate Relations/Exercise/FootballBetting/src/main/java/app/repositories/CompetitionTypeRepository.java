package app.repositories;

import app.domain.CompetitionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetitionTypeRepository extends JpaRepository<CompetitionType, Long> {

}
