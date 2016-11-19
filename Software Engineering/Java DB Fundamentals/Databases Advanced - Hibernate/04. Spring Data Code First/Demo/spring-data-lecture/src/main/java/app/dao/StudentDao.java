package app.dao;

import app.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface StudentDao extends JpaRepository<Student, Long> {

    List<Student> findByFirstNameIn(List<String> firstNames);

    List<Student> findByFirstName(String firstName);
}
