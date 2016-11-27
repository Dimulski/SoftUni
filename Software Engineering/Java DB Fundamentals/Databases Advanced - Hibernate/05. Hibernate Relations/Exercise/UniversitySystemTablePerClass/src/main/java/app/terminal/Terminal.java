package app.terminal;

import app.domain.Course;
import app.domain.Student;
import app.domain.Teacher;
import app.domain.contracts.User;
import app.service.contracts.BasicUserService;
import app.service.contracts.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

@Component
public class Terminal implements CommandLineRunner {

    @Autowired
    private BasicUserService basicUserService;

    @Autowired
    private CourseService courseService;

    @Override
    public void run(String... strings) throws Exception {
        User pesho = new Student("Pesho", "Peshev", "0899123456", 5.50, 6);
        User nakov = new Teacher("Svetlin", "Nakov", "0898123456", "nakov@softuni.bg", new BigDecimal(500));
        this.basicUserService.create((Student)pesho);
        this.basicUserService.create((Teacher)nakov);
        Course hibernate = new Course("Database Advanced - Hibernate",
                "Cool description", new Date(), new Date(), 15, (Teacher)nakov);
        this.courseService.create(hibernate);
    }
}
