package softuni.areas.tasks.entities;

import softuni.areas.characters.entities.Character;
import softuni.areas.tasks.enums.Status;
import softuni.areas.tasks.enums.TaskType;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Task {
    private Long id;

    private TaskType type;

    private String description;

    private String title;

    private Long time;

    private Character character;

    private Status status = Status.INACTIVE;

    private Date endDate;

    private Long xp;

    public Task(TaskType type, String description, String title, Long time, Long xp) {
        this.type = type;
        this.description = description;
        this.title = title;
        this.time = time;
        this.xp = xp;
    }

    public Task() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TaskType getType() {
        return type;
    }

    public void setType(TaskType type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getTime() {
        return time;
    }

    public void setTime(Long time) {
        this.time = time;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @ManyToOne
    @JoinColumn
    public Character getCharacter() {
        return character;
    }

    public void setCharacter(Character character) {
        this.character = character;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Long getXp() {
        return xp;
    }

    public void setXp(Long xp) {
        this.xp = xp;
    }
}
