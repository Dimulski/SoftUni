package app.service;

import app.domain.Student;
import app.repository.StudentRepository;
import app.service.contracts.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void save(Student student) {
        this.studentRepository.saveAndFlush(student);
    }

    @Override
    public void delete(Student student) {
        this.studentRepository.delete(student);
    }

    @Override
    public void delete(long id) {
        this.studentRepository.delete(id);
    }

    @Override
    public Student getStudent(long id) {
        return this.studentRepository.findById(id);
    }

    @Override
    public List<Student> getStudents() {
        return this.studentRepository.findAll();
    }

    @Override
    public List<Object[]> getStudentsAndTheirAggregatedData() {
        return this.studentRepository.findStudentsAndTheirAggregatedData();
    }
}
