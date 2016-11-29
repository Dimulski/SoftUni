package app.domain;

import app.domain.contracts.Vehicle;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "non_motor_vehicles")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class NonMotorVehicle implements Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT UNSIGNED")
    private long id;

    @Basic
    private String manufacturer;

    @Basic
    private String model;

    @Basic
    private BigDecimal price;

    @Basic
    private int maxSpeed;

    protected NonMotorVehicle() {
        super();
    }

    protected NonMotorVehicle(String manufacturer, String model, BigDecimal price, int maxSpeed) {
        this.setManufacturer(manufacturer);
        this.setModel(model);
        this.setPrice(price);
        this.setMaxSpeed(maxSpeed);
    }

    @Override
    public String getManufacturer() {
        return this.manufacturer;
    }

    @Override
    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String getModel() {
        return this.model;
    }

    @Override
    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public BigDecimal getPrice() {
        return this.price;
    }

    @Override
    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public int getMaxSpeed() {
        return this.maxSpeed;
    }

    @Override
    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}
