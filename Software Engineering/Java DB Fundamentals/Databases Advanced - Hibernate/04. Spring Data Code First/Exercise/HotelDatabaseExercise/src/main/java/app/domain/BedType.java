package app.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.io.Serializable;
import java.util.Set;

@Entity
public class BedType implements Serializable {

    @Id
    private String bedType;

    @OneToMany(mappedBy = "bedType", targetEntity = Room.class)
    private Set<Room> rooms;

    @Column(columnDefinition = "TEXT")
    private String notes;

    public BedType() {
        super();
    }

    public String getBedType() {
        return bedType;
    }

    public void setBedType(String bedType) {
        this.bedType = bedType;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
