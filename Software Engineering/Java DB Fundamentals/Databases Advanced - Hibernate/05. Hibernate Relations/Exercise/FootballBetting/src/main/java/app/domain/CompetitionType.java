package app.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "competition_types")
public class CompetitionType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT UNSIGNED")
    private long id;

    @Basic
    private String name;

    public CompetitionType() {
        super();
    }

    public CompetitionType(String name) {
        this.setName(name);
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
}
