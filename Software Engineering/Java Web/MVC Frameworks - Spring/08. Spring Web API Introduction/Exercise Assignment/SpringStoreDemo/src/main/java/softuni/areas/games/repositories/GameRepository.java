package softuni.areas.games.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.areas.games.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
}
