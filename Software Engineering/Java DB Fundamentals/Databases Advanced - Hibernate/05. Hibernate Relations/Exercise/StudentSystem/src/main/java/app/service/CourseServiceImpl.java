package app.service;

import app.domain.Course;
import app.repository.CourseRepository;
import app.service.contracts.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void save(Course course) {
        this.courseRepository.saveAndFlush(course);
    }

    @Override
    public void delete(Course course) {
        this.courseRepository.delete(course);
    }

    @Override
    public void delete(long id) {
        this.courseRepository.delete(id);
    }

    @Override
    public Course getCourse(long id) {
        return this.courseRepository.findById(id);
    }

    @Override
    public List<Course> getCourses() {
        return this.courseRepository.findAll();
    }

    @Override
    public List<Course> getCoursesOrderedByStartDateEndDate() {
        return this.courseRepository.findAllCoursesOrderByStartDateEndDate();
    }

    @Override
    public List<Course> getCoursesWithMoreThan5ResourcesOrdered() {
        return this.courseRepository.findCoursesWithMoreThan5ResourcesOrdered();
    }

    @Override
    public List<Course> getCoursesActiveOnDateOrdered(Date date) {
        return this.courseRepository.findCoursesActiveInGivenDateOrdered(date);
    }
}
