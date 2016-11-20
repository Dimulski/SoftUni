package app.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class RoomType implements Serializable {

    @Id
    private String roomType;

    @OneToMany(mappedBy = "roomType", targetEntity = Room.class)
    private Set<Room> rooms;

    @Column(columnDefinition = "TEXT")
    private String notes;

    public RoomType() {
        super();
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
