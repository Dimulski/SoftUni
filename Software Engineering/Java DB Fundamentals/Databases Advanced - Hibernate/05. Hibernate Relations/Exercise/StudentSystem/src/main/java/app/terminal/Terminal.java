package app.terminal;

import app.domain.Course;
import app.domain.Homework;
import app.domain.Resource;
import app.domain.Student;
import app.domain.enums.ContentType;
import app.domain.enums.ResourceType;
import app.service.contracts.CourseService;
import app.service.contracts.HomeworkService;
import app.service.contracts.ResourceService;
import app.service.contracts.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.expression.ParseException;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Component
public class Terminal implements CommandLineRunner {

    @Autowired
    private CourseService courseService;

    @Autowired
    private HomeworkService homeworkService;

    @Autowired
    private ResourceService resourceService;

    @Autowired
    private StudentService studentService;

    private static Random random = new Random();
    private static SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    private static StringBuilder sb;

    @Override
    public void run(String... strings) throws Exception {
        //this.seedDatabase();

        //this.printAllStudentsAndTheirHomework();

        //this.printAllCoursesAndTheirResources();

        //this.printCoursesWithMoreThan5Resources();

        //this.printCoursesActiveOn(formatter.parse("13/05/2015"));

        this.printStudentsAndTheirStats();
    }

    private void seedDatabase() throws IOException, ParseException, java.text.ParseException {
        List<Course> courses = this.seedCourses();
        List<Student> students = this.seedStudents(courses);
        this.seedHomework(courses, students);
        this.seedResources(courses);
    }

    private void printAllStudentsAndTheirHomework() {
        sb = new StringBuilder();
        List<Student> students = this.studentService.getStudents();
        for (Student s : students) {
            sb.append(String.format("%s\nAll homework:\n", s.getName()));
            for (Homework h : s.getHomework()) {
                sb.append(String.format("\t%s - %s\n", h.getContent(), h.getContentType()));
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    private void printAllCoursesAndTheirResources() {
        sb = new StringBuilder();
        List<Course> courses = this.courseService.getCoursesOrderedByStartDateEndDate();
        for (Course c : courses) {
            sb.append(String.format("%s - %s\nResources:\n", c.getName(), c.getDescription()));
            for (Resource r : c.getResources()) {
                sb.append(String.format("\t%s %s %s\n", r.getName(), r.getResourceType(), r.getUrl()));
            }
            sb.append(System.lineSeparator());
        }
        System.out.println(sb);
    }

    private void printCoursesWithMoreThan5Resources() {
        sb = new StringBuilder();
        this.courseService.getCoursesWithMoreThan5ResourcesOrdered()
                .forEach(c -> sb.append(String.format(
                "%s - %s resources\n",
                c.getName(),
                c.getResources().size())));
        System.out.println(sb);
    }

    private void printCoursesActiveOn(Date date) {
        sb = new StringBuilder();
        List<Course> courses = this.courseService.getCoursesActiveOnDateOrdered(date);
        for (Course c : courses) {
            sb.append(String.format(
                    "%s %s - %s\nDuration - %d\nStudents enrolled - %d\n\n",
                    c.getName(),
                    c.getStartDate(),
                    c.getEndDate(),
                    this.calculateDateDifference(c.getStartDate(), c.getEndDate()),
                    c.getStudents().size()));
        }
        System.out.println(sb);
    }

    private void printStudentsAndTheirStats() {
        sb = new StringBuilder();
        List<Object[]> studentsStats = this.studentService.getStudentsAndTheirAggregatedData();
        for (Object[] studentStats : studentsStats) {
            String studentName = (String) studentStats[0];
            long enrolledCoursesCount = (long) studentStats[1];
            double coursesTotalPrice = (double) studentStats[2];
            double coursesAveragePrice = (double) studentStats[3];
            System.out.printf("%s\nCourses enrolled in: %d\nCourses total price: %s\nCourses average price: %s\n\n",
                    studentName, enrolledCoursesCount, coursesTotalPrice, coursesAveragePrice);
        }
    }

    private void seedResources(List<Course> courses) throws IOException {
        BufferedReader resourceReader = new BufferedReader(new FileReader("res/resources.txt"));
        String line;

        while ((line = resourceReader.readLine()) != null) {
            String[] data = line.split("\\s+");
            String name = data[0];
            ResourceType resourceType = ResourceType.valueOf(data[1]);
            String url = data[2];
            int courseIndex = random.nextInt(courses.size());
            Course course = courses.get(courseIndex);
            Resource resource = new Resource(name, resourceType, url, course);
            this.resourceService.save(resource);
        }
    }

    private void seedHomework(List<Course> courses, List<Student> students) throws IOException, ParseException, java.text.ParseException {
        BufferedReader homeworkReader = new BufferedReader(new FileReader("res/homework.txt"));
        String line;
        while ((line = homeworkReader.readLine()) != null) {
            String[] data = line.split("\\s+");
            String content = data[0];
            ContentType contentType = ContentType.valueOf(data[1]);
            Date submissionDate = formatter.parse(data[2]);
            int courseIndex = random.nextInt(courses.size());
            int studentIndex = random.nextInt(students.size());
            Course course = courses.get(courseIndex);
            Student student = students.get(studentIndex);
            Homework homework = new Homework(content, contentType, submissionDate, course, student);
            this.homeworkService.save(homework);
        }
    }

    private List<Course> seedCourses() throws IOException, ParseException, java.text.ParseException {
        BufferedReader courseReader = new BufferedReader(new FileReader("res/courses.txt"));
        String line;
        List<Course> courses = new LinkedList<>();
        while ((line = courseReader.readLine()) != null) {
            String[] data = line.split("\\s+");
            String courseName = data[0];
            Date startDate = formatter.parse(data[1]);
            Date endDate = formatter.parse(data[2]);
            double price = Double.parseDouble(data[3]);
            Course course = new Course(courseName, "No description", startDate, endDate, price);
            this.courseService.save(course);
            courses.add(course);
        }

        return courses;
    }

    private List<Student> seedStudents(List<Course> courses) throws IOException, ParseException, java.text.ParseException {
        BufferedReader studentReader = new BufferedReader(new FileReader("res/students.txt"));
        String line;
        List<Student> students = new LinkedList<>();
        while ((line = studentReader.readLine()) != null) {
            String[] data = line.split("\\s+");
            String name = data[0];
            String phoneNumber = data[1];
            Date registrationDate = formatter.parse(data[2]);
            Date birthday = formatter.parse(data[3]);
            int courseIndex = random.nextInt(courses.size());
            Course course = courses.get(courseIndex);

            Student student = new Student(name, phoneNumber, registrationDate, birthday);
            student.getCourses().add(course);
            this.studentService.save(student);
            students.add(student);
        }

        return students;
    }

    private long calculateDateDifference(Date startDate, Date endDate) {
        long duration = endDate.getTime() - startDate.getTime();
        long diff = TimeUnit.MILLISECONDS.toDays(duration);
        return diff;
    }
}
