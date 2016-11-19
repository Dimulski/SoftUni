package app.repositories;

import app.domain.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}
