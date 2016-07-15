package bg.softuni.contracts;

public interface Requester {

    void getStudentMarkInCourse(String courseName, String studentName);

    void getStudentsByCourse(String courseName);
}
