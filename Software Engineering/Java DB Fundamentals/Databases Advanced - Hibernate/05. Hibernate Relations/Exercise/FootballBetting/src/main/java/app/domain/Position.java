package app.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "positions")
public class Position implements Serializable {

    @Id
    @Column(length = 2)
    private String id;

    @Basic
    private String positionDescription;

    @OneToMany(mappedBy = "position", targetEntity = Player.class)
    private Set<Player> players;

    public Position() {
        this.setPlayers(new HashSet<>());
    }

    public Position(String id, String positionDescription) {
        this();
        this.setId(id);
        this.setPositionDescription(positionDescription);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPositionDescription() {
        return positionDescription;
    }

    public void setPositionDescription(String positionDescription) {
        this.positionDescription = positionDescription;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }
}
