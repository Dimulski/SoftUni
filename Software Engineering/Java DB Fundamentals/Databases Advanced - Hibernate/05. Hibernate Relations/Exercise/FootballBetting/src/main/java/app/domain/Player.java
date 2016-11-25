package app.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "players")
public class Player implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT UNSIGNED")
    private long id;

    @Basic
    private String name;

    @Basic
    private int squadNumber;

    @Basic
    private String team;

    @Basic
    private Position position;

    @Basic
    private boolean isCurrentlyInjured;

    public Player() {
        super();
    }

    public Player(String name, int squadNumber, String team, Position position, boolean isCurrentlyInjured) {
        this.setName(name);
        this.setSquadNumber(squadNumber);
        this.setTeam(team);
        this.setPosition(position);
        this.setIsCurrentlyInjured(isCurrentlyInjured);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSquadNumber() {
        return squadNumber;
    }

    public void setSquadNumber(int squadNumber) {
        this.squadNumber = squadNumber;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public boolean getIsCurrentlyInjured() {
        return isCurrentlyInjured;
    }

    public void setIsCurrentlyInjured(boolean isCurrentlyInjured) {
        this.isCurrentlyInjured = isCurrentlyInjured;
    }
}
