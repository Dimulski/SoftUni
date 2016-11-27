package app.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "competitions")
public class Competition implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT UNSIGNED")
    private long id;

    @Basic
    private String name;

    @ManyToOne
    @JoinColumn(name = "competition_type_id", referencedColumnName = "id")
    private CompetitionType competitionType;

    public Competition() {
        super();
    }

    public Competition(String name, CompetitionType competitionType) {
        this.setName(name);
        this.setCompetitionType(competitionType);
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

    public CompetitionType getCompetitionType() {
        return competitionType;
    }

    public void setCompetitionType(CompetitionType competitionType) {
        this.competitionType = competitionType;
    }
}
