package exercises.dataFactory;

import exercises.domain.courses.Course;
import exercises.domain.enums.MyContentType;
import exercises.domain.enums.MyResourceType;
import exercises.domain.homeworks.Homework;
import exercises.domain.resources.Resource;
import exercises.domain.student.Student;
import exercises.repositories.CourseDao;
import exercises.repositories.HomeworkDao;
import exercises.repositories.ResourceDao;
import exercises.repositories.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Component
public class DataFactory {

    private final CourseDao courseDao;

    private final HomeworkDao homeworkDao;

    private final ResourceDao resourceDao;

    private final StudentDao studentDao;

    @Autowired
    public DataFactory(CourseDao courseDao, HomeworkDao homeworkDao, ResourceDao resourceDao, StudentDao studentDao) {
        this.courseDao = courseDao;
        this.homeworkDao = homeworkDao;
        this.resourceDao = resourceDao;
        this.studentDao = studentDao;
    }

    public void seed(){
        if(this.isDatabasePopulated()){
            return;
        }

        Course course = new Course();
        course.setName("Java DB");
        course.setDescription("The best course");
        course.setStartDate(new Date());
        course.setEndDate(new Date());
        course.setPrice(new BigDecimal("0"));
        courseDao.saveAndFlush(course);

        Student student = new Student();
        student.setName("Ivan");
        student.setBirthday(new Date());
        student.setPhoneNumber("089896597864");
        student.setRegistrationDate(new Date());
        student.getCourses().add(course);
        studentDao.saveAndFlush(student);

        Homework homework = new Homework();
        homework.setContent("Relations");
        homework.setContentType(MyContentType.PDF);
        homework.setSubmissionDate(new Date());
        homework.setCourse(course);
        homework.setStudent(student);
        homeworkDao.saveAndFlush(homework);

        Resource resource = new Resource();
        resource.setName("Lab");
        resource.setType(MyResourceType.DOCUMENT);
        resource.setURL("url");
        resource.setCourse(course);
        resourceDao.saveAndFlush(resource);
    }

    private boolean isDatabasePopulated(){

        if(this.courseDao.count() > 0){
            return true;
        }

        if(this.studentDao.count() > 0){
            return true;
        }

        if(this.homeworkDao.count() > 0){
            return true;
        }

        if(this.resourceDao.count() > 0){
            return true;
        }

        return false;
    }

    public List<Object[]> getCourses(){
        return this.courseDao.getCourses();
    }
}
