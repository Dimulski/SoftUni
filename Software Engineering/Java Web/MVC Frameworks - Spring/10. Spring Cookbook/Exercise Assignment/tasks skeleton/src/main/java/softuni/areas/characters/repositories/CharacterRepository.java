package softuni.areas.characters.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import softuni.areas.characters.entities.Character;

import java.util.List;

public interface CharacterRepository extends JpaRepository<Character, Long> {
    List<Character> findByOwnerId(Long id);
    List<Character> findTop10ByOrderByXpDesc();
}
