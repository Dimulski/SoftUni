package Problem2UniqueStudentNames;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UniqueStudentNames {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StudentGroup group = new StudentGroup();
        String line;
        while(!(line = reader.readLine()).equals("End")) {
            Student student = new Student(line);
            group.addStudent(student);
        }
        System.out.println(StudentGroup.studentsWithUniqueName);
    }
}

class Student {
    String name;

    Student(String name) {
        this.name = name;
    }
}

class StudentGroup {
    static Integer studentsWithUniqueName;
    private ArrayList<Student> students;

    StudentGroup() {
        this.students = new ArrayList<>();
        studentsWithUniqueName = 0;
    }

    void addStudent(Student student) {
        boolean isNameUnique = true;
        for (Student s : students) {
            if (student.name.equals(s.name)) {
                isNameUnique = false;
            }
        }
        if (isNameUnique) studentsWithUniqueName++;
        this.students.add(student);
    }
}
