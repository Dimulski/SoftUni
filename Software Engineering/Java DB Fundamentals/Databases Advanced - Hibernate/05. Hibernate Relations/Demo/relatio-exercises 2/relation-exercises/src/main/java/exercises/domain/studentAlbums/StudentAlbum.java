package exercises.domain.studentAlbums;

import exercises.domain.albums.Album;
import exercises.domain.roles.Role;
import exercises.domain.student.Student;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "students_albums")
public class StudentAlbum implements Serializable {

    @Id
    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id")
    private Student student;

    @Id
    @ManyToOne
    @JoinColumn(name = "album_id", referencedColumnName = "id")
    private Album album;

    @Id
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

    public StudentAlbum() {
    }

    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Album getAlbum() {
        return this.album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }

    public Role getRole() {
        return this.role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
