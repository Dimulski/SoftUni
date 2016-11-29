package app.domain;

import javax.persistence.Basic;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "carriage")
public class PassengerCarriage extends Carriage {

    @Basic
    private int standingPassengerCapacity;

    public PassengerCarriage() {
        super();
    }

    public PassengerCarriage(int passengerSeatCapacity, Train train, int standingPassengerCapacity) {
        super(passengerSeatCapacity, train);
        this.setStandingPassengerCapacity(standingPassengerCapacity);
    }

    public int getStandingPassengerCapacity() {
        return standingPassengerCapacity;
    }

    public void setStandingPassengerCapacity(int standingPassengerCapacity) {
        this.standingPassengerCapacity = standingPassengerCapacity;
    }
}
