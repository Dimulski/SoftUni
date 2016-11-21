package exercises.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import exercises.domain.student.Student;

import java.util.List;

@Repository
public interface StudentDao extends JpaRepository<Student,Long> {

}