package app.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "positions")
public class Position implements Serializable {

    @Id
    @Column(length = 2)
    private String id;

    @Basic
    private String positionDescription;

    public Position() {
        super();
    }

    public Position(String id, String positionDescription) {
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
}
