import dao.StudentDaoImpl;
import interfaces.StudentDao;
import models.Student;

import java.sql.SQLException;

/**
 * Created by teodo on 19/10/2016.
 */
public class DemoDao {
    public static void main(String[] args) {

        try(StudentDao studentDao = new StudentDaoImpl()) {

//            Student student = new Student();
//            student.setName("Pesho");

           // studentDao.insertStudent(student);

            studentDao.getAllStudents().forEach(f -> {
                Student student = new Student();
                if(f.getId() == 4) {
                    student.setId(f.getId());
                    student.setName("Minka");
                    try {
                        studentDao.updateStudent(student);
                        studentDao.deleteStudent(student);
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
