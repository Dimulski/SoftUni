package app.console;

import app.domain.Major;
import app.domain.Student;
import app.service.MajorService;
import app.service.StudentService;
import app.serviceImpl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class Terminal implements CommandLineRunner {

    @Autowired
    private StudentService studentService;

    @Autowired
    private MajorService majorService;

    @Override
    public void run(String... strings) throws Exception {

        Major major = new Major("IT");
        Student student = new Student("John", "A.", new Date(), major);
        this.majorService.create(major);
        this.studentService.register(student);

        List<String> studentNames = new ArrayList<>();
        studentNames.add("John");
        studentNames.add("Pesho");
        List<Student> students = this.studentService.findByFirstName(studentNames);
//        for (Student st : students) {
//            System.out.println(st.getFirstName());
//        }

       //this.majorService.deleteByName("IT");
    }
}