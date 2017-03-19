package softuni.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {
}
