package app.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "occupancies")
public class Occupancy implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT UNSIGNED")
    private long id;

    @Basic
    private Date dateOccupied;

    @Basic
    private long accountNumber;

    @Basic
    private long roomNumber;

    @Basic
    private double rateApplied;

    @Basic
    private double phoneCharge;

    @Column(columnDefinition = "TEXT")
    private String notes;

    public Occupancy() {
        super();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDateOccupied() {
        return dateOccupied;
    }

    public void setDateOccupied(Date dateOccupied) {
        this.dateOccupied = dateOccupied;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public long getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(long roomNumber) {
        this.roomNumber = roomNumber;
    }

    public double getRateApplied() {
        return rateApplied;
    }

    public void setRateApplied(double rateApplied) {
        this.rateApplied = rateApplied;
    }

    public double getPhoneCharge() {
        return phoneCharge;
    }

    public void setPhoneCharge(double phoneCharge) {
        this.phoneCharge = phoneCharge;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
