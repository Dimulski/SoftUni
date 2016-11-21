package exercises.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import exercises.domain.courses.Course;

import java.util.List;

@Repository
public interface CourseDao extends JpaRepository<Course,Long> {

    @Query(value = "SELECT c.name, c.description, r FROM Resource AS r INNER JOIN r.course AS c")
    List<Object[]> getCourses();
}