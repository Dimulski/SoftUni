package exercises.domain.resources;

import exercises.domain.courses.Course;
import exercises.domain.enums.MyResourceType;

import javax.persistence.*;

@Entity
@Table(name = "resources")
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Basic
    private String name;

    @Enumerated(EnumType.STRING)
    private MyResourceType type;

    @Basic
    private String URL;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    public Resource() {
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

    public MyResourceType getType() {
        return this.type;
    }

    public void setType(MyResourceType type) {
        this.type = type;
    }

    public String getURL() {
        return this.URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public Course getCourse() {
        return this.course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }
}
