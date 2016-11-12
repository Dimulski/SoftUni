package exercises.domain.courses;

import exercises.domain.homeworks.Homework;
import exercises.domain.resources.Resource;
import exercises.domain.student.Student;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Basic
    private String name;

    @Basic(optional = true)
    private String description;

    @Column(name = "start_Date")
    private Date startDate;

    @Column(name = "end_Date")
    private Date endDate;

    @Basic
    private BigDecimal price;

    @ManyToMany(mappedBy = "courses")
    private Set<Student> students;

    @OneToMany(mappedBy = "course")
    private Set<Resource> resources;

    @OneToMany(mappedBy = "course")
    private Set<Homework> homeworks;

    public Course() {
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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getPrice() {
        return this.price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Set<Student> getStudents() {
        return this.students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
