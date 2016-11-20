package app.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "rooms")
public class Room implements Serializable {

    @Id
    @Column(columnDefinition = "BIGINT UNSIGNED")
    private long roomNumber;

    @ManyToOne
    @JoinColumn(name = "room_type", referencedColumnName = "roomType")
    private RoomType roomType;

    @ManyToOne
    @JoinColumn(name = "bed_type", referencedColumnName = "bedType")
    private BedType bedType;

    @ManyToOne
    @JoinColumn(name = "room_status", referencedColumnName = "roomStatus")
    private RoomStatus roomStatus;

    @Basic
    private double rate;

    @Column(columnDefinition = "TEXT")
    private String notes;

    public Room() {
        super();
    }

    public long getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(long roomNumber) {
        this.roomNumber = roomNumber;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public BedType getBedType() {
        return bedType;
    }

    public void setBedType(BedType bedType) {
        this.bedType = bedType;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public RoomStatus getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        this.roomStatus = roomStatus;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
