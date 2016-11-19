package app.dao;

import app.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UserDao extends JpaRepository<User, Long> {

    List<User> findByEmail(String email);

    int countByProfilePictureGreaterThan(byte[] size);
}
