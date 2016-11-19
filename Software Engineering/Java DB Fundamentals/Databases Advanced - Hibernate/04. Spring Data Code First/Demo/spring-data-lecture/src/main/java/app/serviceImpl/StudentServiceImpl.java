package app.serviceImpl;

import app.dao.StudentDao;
import app.domain.Student;
import app.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public void register(Student student) {
        studentDao.saveAndFlush(student);
    }

    @Override
    public void expel(Student student) {
        studentDao.delete(student);
    }

    @Override
    public Student find(long id) {
        return studentDao.findOne(id);
    }

    @Override
    public List<Student> findByFirstName(List<String> firstNames) {
        return studentDao.findByFirstNameIn(firstNames);
    }

    @Override
    public List<Student> findByFirstName(String firstName) {
        return studentDao.findByFirstName(firstName);
    }
}
