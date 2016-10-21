package dao;

import connection.DatabaseConnection;
import interfaces.StudentDao;
import models.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by teodo on 19/10/2016.
 */
public class StudentDaoImpl implements StudentDao {

    private static final String SQL_SELECT = "SELECT * FROM students";

    private static final String SQL_INSERT = "INSERT INTO students(id, name) " +
            "VALUES(?,?)";

    private static final String SQL_UPDATE = "UPDATE students " +
            "SET name = ? " +
            "WHERE id = ?";

    private static final String SQL_DELETE = "DELETE FROM students " +
            "WHERE id = ?";

    private List<Student> students;

    private Connection connection;

    private PreparedStatement preparedStatement;

    private ResultSet resultSet;

    public StudentDaoImpl() {
        this.students = new ArrayList<>();
    }

    @Override
    public List<Student> getAllStudents() throws SQLException {
        this.connection = DatabaseConnection.getConnection();
        this.preparedStatement = this.connection.prepareStatement(SQL_SELECT);
        this.resultSet = this.preparedStatement.executeQuery();

        while (resultSet.next()){
            int id = resultSet.getInt("id");
            String name = resultSet.getString("name");
            Student student = new Student();
            student.setId(id);
            student.setName(name);
            this.students.add(student);
        }

        return Collections.unmodifiableList(this.students);
    }

    @Override
    public void insertStudent(Student student) throws SQLException {
        this.connection = DatabaseConnection.getConnection();
        this.preparedStatement = connection.prepareStatement(SQL_INSERT);
        int id = student.getId();
        this.preparedStatement.setInt(1, id);
        String name = student.getName();
        this.preparedStatement.setString(2, name);
        this.preparedStatement.execute();
    }

    @Override
    public void updateStudent(Student student) throws SQLException {
        this.connection = DatabaseConnection.getConnection();
        this.preparedStatement = connection.prepareStatement(SQL_UPDATE);
        String name = student.getName();
        this.preparedStatement.setString(1, name);
        int id = student.getId();
        this.preparedStatement.setInt(2, id);
        this.preparedStatement.execute();
    }

    @Override
    public void deleteStudent(Student student) throws SQLException {
        this.connection = DatabaseConnection.getConnection();
        this.preparedStatement = connection.prepareStatement(SQL_DELETE);
        int id = student.getId();
        this.preparedStatement.setInt(1, id);
        this.preparedStatement.execute();
    }

    @Override
    public void close() throws Exception {

        if(this.resultSet != null){
            this.resultSet.close();
        }

        if(this.preparedStatement != null){
            this.preparedStatement.close();
        }

        if(this.connection != null){
            this.connection.close();
        }
    }
}
