package exercises.domain.student;

import exercises.domain.courses.Course;
import exercises.domain.homeworks.Homework;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String name;

    @Column(name = "phone_number", nullable = true)
    private String phoneNumber;

    @Column(name = "registration_date")
    private Date registrationDate;

    @Column(nullable = true)
    private Date birthday;

    @ManyToMany
    @JoinTable(name = "students_courses",
    joinColumns = @JoinColumn(name = "student_id"),
    inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> courses;

    @OneToMany(mappedBy = "student")
    private Set<Homework> homeworks;

    public Student() {
        this.setCourses(new HashSet<>());
        this.setHomeworks(new HashSet<>());
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getRegistrationDate() {
        return this.registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Date getBirthday() {
        return this.birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Set<Course> getCourses() {
        return this.courses;
    }

    public void setCourses(Set<Course> courses) {
        this.courses = courses;
    }

    public Set<Homework> getHomeworks() {
        return this.homeworks;
    }

    public void setHomeworks(Set<Homework> homeworks) {
        this.homeworks = homeworks;
    }
}
