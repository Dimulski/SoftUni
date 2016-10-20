package Problem3Mankind;

import Problem3Mankind.models.Human;
import Problem3Mankind.models.Student;
import Problem3Mankind.models.Worker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] studentParams = reader.readLine().split(" ");
        String[] workerParams = reader.readLine().split(" ");
        Human student;
        Human worker;
        try {
            student = new Student(studentParams[0], studentParams[1], studentParams[2]);
            worker = new Worker(workerParams[0], workerParams[1], Double.parseDouble(workerParams[2]), Double.parseDouble(workerParams[3]));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println(student);
        System.out.println(worker);
    }
}
