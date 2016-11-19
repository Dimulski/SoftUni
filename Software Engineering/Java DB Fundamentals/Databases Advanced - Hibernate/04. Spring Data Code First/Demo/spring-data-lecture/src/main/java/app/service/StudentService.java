package app.service;

import app.domain.Student;

import java.util.List;

public interface StudentService {

    void register(Student student);

    void expel(Student student);

    Student find(long id);

    List<Student> findByFirstName(List<String> firstNames);

    List<Student> findByFirstName(String firstName);
}
