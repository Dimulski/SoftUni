package softuni.areas.characters.entities;

import softuni.areas.characters.enums.CharacterType;
import softuni.areas.tasks.entities.Task;
import softuni.areas.tasks.enums.TaskType;
import softuni.areas.users.entities.User;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "characters")
public class Character {

    private Long id;

    private Long xp = 0L;

    private String name;

    private Long money = 0L;

    private Boolean onMission = false;

    private User owner;

    private Set<Task> tasks = new HashSet<>(0);

    public Character(String name, User owner) {
        this.name = name;
        this.owner = owner;
    }

    public Character() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getXp() {
        return xp;
    }

    public void setXp(Long xp) {
        this.xp = xp;
    }

    @Transient
    public CharacterType getType() {
        return CharacterType.of(TaskType.Application);
    }

    @Column(unique = true, nullable = false)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }

    public Boolean getOnMission() {
        return onMission;
    }

    public void setOnMission(Boolean onMission) {
        this.onMission = onMission;
    }

    @ManyToOne
    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @OneToMany(mappedBy = "character", fetch = FetchType.EAGER)
    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }

    @Transient
    public void addXp(Long xp) {
        this.xp += xp;
    }

    @Transient
    public void addMoney(Long money) {
        this.money += money;
    }
}
