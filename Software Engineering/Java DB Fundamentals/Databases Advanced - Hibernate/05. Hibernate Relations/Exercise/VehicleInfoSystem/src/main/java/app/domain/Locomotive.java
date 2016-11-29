package app.domain;

import javax.persistence.*;

@Entity
@Table(name = "locomotives")
public class Locomotive {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT UNSIGNED")
    private long id;

    @Basic
    private String model;

    @Basic
    private double power;

    @OneToOne(mappedBy = "locomotive", targetEntity = Train.class)
    private Train train;

    public Locomotive() {
        super();
    }

    public Locomotive(String model, double power, Train train) {
        this.setModel(model);
        this.setPower(power);
        this.setTrain(train);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public Train getTrain() {
        return train;
    }

    public void setTrain(Train train) {
        this.train = train;
    }
}
