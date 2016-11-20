package app.repositories;

import app.domain.RoomStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface RoomStatusRepository extends JpaRepository<RoomStatus, String> {

}
