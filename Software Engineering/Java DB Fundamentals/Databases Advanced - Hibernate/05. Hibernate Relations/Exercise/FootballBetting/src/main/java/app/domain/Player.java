package app.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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

    @ManyToOne
    @JoinColumn(name = "team_id", referencedColumnName = "id")
    private Team team;

    @ManyToOne
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private Position position;

    @Basic
    private boolean isCurrentlyInjured;

    @ManyToMany
    @JoinTable(name = "players_games",
    joinColumns = @JoinColumn(name = "player_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "game_id", referencedColumnName = "id"))
    private Set<Game> games;

    public Player() {
        this.setGames(new HashSet<>());
    }

    public Player(String name, int squadNumber, Team team, Position position, boolean isCurrentlyInjured) {
        this();
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

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
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

    public Set<Game> getGames() {
        return games;
    }

    public void setGames(Set<Game> games) {
        this.games = games;
    }
}
