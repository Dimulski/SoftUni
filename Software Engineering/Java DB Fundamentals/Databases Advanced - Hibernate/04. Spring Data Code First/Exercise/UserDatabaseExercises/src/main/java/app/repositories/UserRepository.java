package app.repositories;

import app.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findByEmail(String email);

    int countByProfilePictureGreaterThan(byte[] size);
}
