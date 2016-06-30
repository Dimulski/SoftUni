package bg.softuni.models;

import bg.softuni.io.OutputWriter;
import bg.softuni.staticData.ExceptionMessages;

import java.util.Arrays;
import java.util.LinkedHashMap;

public class Student {

    public String userName;
    public LinkedHashMap<String, Course> enrolledCourses;
    public LinkedHashMap<String, Double> marksByCourseName;

    public Student(String userName) {
        this.userName = userName;
        this.enrolledCourses = new LinkedHashMap<>();
        this.marksByCourseName = new LinkedHashMap<>();
    }

    public void enrollInCourse(Course course) {
        if (this.enrolledCourses.containsKey(course.name)) {
            OutputWriter.displayException(String.format(
                    ExceptionMessages.STUDENT_ALREADY_ENROLLED_IN_GIVEN_COURSE,
                    this.userName, course.name));
            return;
        }

        this.enrolledCourses.put(course.name, course);
    }

    public void serMarksInCourse(String courseName, int... scores) {
        if (!this.enrolledCourses.containsKey(courseName)) {
            OutputWriter.displayException(ExceptionMessages.NOT_ENROLLED_IN_COURSE);
            return;
        }

        if (scores.length > Course.NUMBER_OF_TASKS_ON_EXAM) {
            OutputWriter.displayException(ExceptionMessages.INVALID_NUMBER_OF_SCORES);
            return;
        }

        double mark = calculateMark(scores);
        this.marksByCourseName.put(courseName, mark);
    }

    private double calculateMark(int[] scores) {
        double percentageOfSolvedExam = Arrays.stream(scores).sum() /
                (double) (Course.NUMBER_OF_TASKS_ON_EXAM * Course.MAX_SCORE_ON_EXAM_TASK);
        double mark = percentageOfSolvedExam * 4 + 2;
        return mark;
    }
}
