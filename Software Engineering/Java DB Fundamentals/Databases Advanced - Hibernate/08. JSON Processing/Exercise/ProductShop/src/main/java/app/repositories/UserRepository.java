package app.repositories;

import app.domain.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u FROM User AS u WHERE u.sellProducts.size >= 1 ORDER BY u.lastName ASC, u.firstName ASC")
    List<User> findUsersWithAtLeastOneSellItem();
}
