package app.domain;

import javax.persistence.Basic;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue(value = "restaurant")
public class RestaurantCarriage extends Carriage {

    @Basic
    private int tableCount;

    public RestaurantCarriage() {
        super();
    }

    public RestaurantCarriage(int passengerSeatCapacity, Train train, int tableCount) {
        super(passengerSeatCapacity, train);
        this.setTableCount(tableCount);
    }

    public int getTableCount() {
        return tableCount;
    }

    public void setTableCount(int tableCount) {
        this.tableCount = tableCount;
    }
}
