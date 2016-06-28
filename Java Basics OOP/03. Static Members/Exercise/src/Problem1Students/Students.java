package Problem1Students;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Students {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while(!(line = reader.readLine()).equals("End")) {
            new Student(line);
        }
        System.out.println(Student.studentsCount);
    }
}

class Student {
    static Integer studentsCount = 0;
    String name;

    Student(String name) {
        this.name = name;
        studentsCount++;
    }
}
