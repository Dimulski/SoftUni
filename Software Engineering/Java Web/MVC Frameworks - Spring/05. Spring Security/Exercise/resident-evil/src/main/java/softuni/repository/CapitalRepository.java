package softuni.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import softuni.entities.Capital;

import java.util.Set;

@Repository
public interface CapitalRepository extends CrudRepository<Capital, Long> {
    
    @Query(value = "SELECT c FROM Capital AS c")
    Set<Capital> findAllCapitals();
    
    Set<Capital> findAllByNameIn(String[] names);
}
