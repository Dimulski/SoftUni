package softuni.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import softuni.entities.Capital;

import java.util.List;
import java.util.Set;

@Repository
public interface CapitalRepository extends CrudRepository<Capital, Long> {
    
    @Query(value = "SELECT c.name FROM Capital AS c")
    List<String> getCapitalNames();
    
    Set<Capital> getAllByNameIn(String[] names);
}
