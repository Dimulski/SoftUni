package app.repository;

import app.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    Student findById(long id);

    List<Student> findAll();

    @Query("SELECT s.name, COUNT(c), SUM(c.price), AVG(c.price) " +
           "FROM Student AS s " +
           "JOIN s.courses AS c " +
           "GROUP BY s " +
           "ORDER BY SUM(c.price) DESC, COUNT(c) DESC, s.name ASC")
    List<Object[]> findStudentsAndTheirAggregatedData();
}
