package app.domain;

import app.domain.contracts.Vehicle;

import javax.persistence.*;

@Entity
@Table(name = "motor_vehicles")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class MotorVehicle implements Vehicle {

}
