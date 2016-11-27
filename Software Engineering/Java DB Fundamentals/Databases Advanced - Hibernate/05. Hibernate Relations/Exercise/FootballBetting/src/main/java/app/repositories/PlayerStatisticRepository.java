package app.repositories;

import app.domain.PlayerStatistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerStatisticRepository extends JpaRepository<PlayerStatistic, Long> {

}
