package app.repositories;

import app.domain.Occupancy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface OccupancyRepository extends JpaRepository<Occupancy, Long> {

}
