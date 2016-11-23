package app.repository;

import app.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    Course findById(long id);

    List<Course> findAll();

    @Query("SELECT c FROM Course AS c ORDER BY c.startDate ASC, c.endDate DESC")
    List<Course> findAllCoursesOrderByStartDateEndDate();

    @Query("SELECT c FROM Course AS c " +
           "JOIN c.resources AS r " +
           "GROUP BY c " +
           "HAVING COUNT(r) > 2 " + // Changed from 5 to 2 for the sake of having results on a tiny database
           "ORDER BY COUNT(r) DESC, c.startDate DESC")
    List<Course> findCoursesWithMoreThan5ResourcesOrdered();

    @Query("SELECT c FROM Course AS c " +
           "JOIN c.students AS s " +
           "GROUP BY c " +
           "HAVING :date BETWEEN c.startDate AND c.endDate " +
           "ORDER BY COUNT(s) DESC, DATEDIFF(c.endDate, c.startDate) DESC")
    List<Course> findCoursesActiveInGivenDateOrdered(@Param(value = "date") Date date);
}
