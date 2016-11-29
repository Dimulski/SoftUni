package app.domain;

import javax.persistence.Basic;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue(value = "bike")
public class Bike extends NonMotorVehicle {

    @Basic
    private int shiftCount;

    @Basic
    private String color;

    public Bike() {
        super();
    }

    public Bike(String manufacturer, String model, BigDecimal price, int maxSpeed, int shiftCount, String color) {
        super(manufacturer, model, price, maxSpeed);
        this.setShiftCount(shiftCount);
        this.setColor(color);
    }

    public int getShiftCount() {
        return shiftCount;
    }

    public void setShiftCount(int shiftCount) {
        this.shiftCount = shiftCount;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
