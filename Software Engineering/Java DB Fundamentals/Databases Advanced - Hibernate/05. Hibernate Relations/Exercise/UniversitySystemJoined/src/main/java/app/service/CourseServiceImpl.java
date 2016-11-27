package app.service;

import app.domain.Course;
import app.repositories.CourseRepository;
import app.service.contracts.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public void create(Course course) {
        this.courseRepository.saveAndFlush(course);
    }
}
