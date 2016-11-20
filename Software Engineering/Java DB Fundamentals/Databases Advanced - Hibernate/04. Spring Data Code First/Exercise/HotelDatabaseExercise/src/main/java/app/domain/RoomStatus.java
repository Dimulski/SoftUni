package app.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
public class RoomStatus implements Serializable {

    @Id
    private String roomStatus;

    @OneToMany(mappedBy = "roomStatus", targetEntity = Room.class)
    private Set<Room> rooms;

    @Column(columnDefinition = "TEXT")
    private String notes;

    public RoomStatus() {
        super();
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
