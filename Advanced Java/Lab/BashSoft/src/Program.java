/**
 * Created by User on 4.6.2016 г..
 */
public class Program {

    public static void main(String[] args) {
        StudentsRepository.InitializeData();
        StudentsRepository.getStudentsByCourse("Unity");
    }
}
