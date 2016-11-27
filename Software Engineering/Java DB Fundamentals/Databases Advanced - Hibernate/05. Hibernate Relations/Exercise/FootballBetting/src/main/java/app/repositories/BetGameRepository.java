package app.repositories;

import app.domain.BetGame;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BetGameRepository extends JpaRepository<BetGame, Long> { // won't work - needs an IdClass

}
