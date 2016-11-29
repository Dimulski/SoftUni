package app.domain;

import javax.persistence.Basic;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "sleeping")
public class SleepingCarriage extends Carriage {

    @Basic
    private int bedCount;

    public SleepingCarriage() {
        super();
    }

    public SleepingCarriage(int passengerSeatCapacity, Train train, int bedCount) {
        super(passengerSeatCapacity, train);
        this.setBedCount(bedCount);
    }

    public int getBedCount() {
        return bedCount;
    }

    public void setBedCount(int bedCount) {
        this.bedCount = bedCount;
    }
}
