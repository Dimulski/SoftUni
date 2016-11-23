package app.service.contracts;

import app.domain.Student;

import java.util.List;

public interface StudentService {

    void save(Student student);

    void delete(Student student);

    void delete(long id);

    Student getStudent(long id);

    List<Student> getStudents();

    List<Object[]> getStudentsAndTheirAggregatedData();
}
