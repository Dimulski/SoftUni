package app.service.contracts;

import app.domain.Course;

import java.util.Date;
import java.util.List;

public interface CourseService  {

    void save(Course course);

    void delete(Course course);

    void delete(long id);

    Course getCourse(long id);

    List<Course> getCourses();

    List<Course> getCoursesOrderedByStartDateEndDate();

    List<Course> getCoursesWithMoreThan5ResourcesOrdered();

    List<Course> getCoursesActiveOnDateOrdered(Date date);
}
