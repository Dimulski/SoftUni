package app.domain;

import app.domain.contracts.Vehicle;

import javax.persistence.*;

@Entity
@Table(name = "non_motor_vehicles")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type")
public abstract class NonMotorVehicle implements Vehicle {

}
