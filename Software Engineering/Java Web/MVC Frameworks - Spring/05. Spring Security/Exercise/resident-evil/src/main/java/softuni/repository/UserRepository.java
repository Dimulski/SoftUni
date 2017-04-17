package softuni.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import softuni.entities.User;

import java.util.List;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
    
    User findByUsername(String username);

    @Query(value = "SELECT u FROM User AS u")
    List<User> findAll();
}
