package softuni.models;

import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import softuni.annotations.IsInTheFuture;
import softuni.entities.enums.Magnitude;
import softuni.entities.enums.Mutation;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Date;

public class VirusBindingModel {

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 3, max = 10, message = "Invalid name size")
    private String name;

    @NotBlank(message = "Description cannot be blank")
    @Size(min = 4, max = 100, message = "Invalid description size")
    private String description;

    @Pattern(regexp = "^.*[Cc]orp.*$", message = "Creator must contain \"corp\"")
    private String creator;

    @Size(max = 50)
    private String sideEffects;

    private boolean isDeadly;

    private boolean isCurable;

    @NotNull(message = "Mutation cannot be null")
    private Mutation mutation;

    @Range(min = 0, max = 100)
    private Double turnoverRate;

    @Range(min = 1, max = 12)
    private Integer hoursToTurn;

    @NotNull(message = "Magnitude cannot be null")
    private Magnitude magnitude;

    @IsInTheFuture(message = "Date of release cannot be in the past")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date releasedOn;

    @NotEmpty(message = "There must be at least one capital")
    private String[] capitals;

    public VirusBindingModel() {
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getSideEffects() {
        return sideEffects;
    }

    public void setSideEffects(String sideEffects) {
        this.sideEffects = sideEffects;
    }

    public boolean isDeadly() {
        return isDeadly;
    }

    public void setDeadly(boolean deadly) {
        isDeadly = deadly;
    }

    public boolean isCurable() {
        return isCurable;
    }

    public void setCurable(boolean curable) {
        isCurable = curable;
    }

    public Mutation getMutation() {
        return mutation;
    }

    public void setMutation(Mutation mutation) {
        this.mutation = mutation;
    }

    public Double getTurnoverRate() {
        return turnoverRate;
    }

    public void setTurnoverRate(Double turnoverRate) {
        this.turnoverRate = turnoverRate;
    }

    public Integer getHoursToTurn() {
        return hoursToTurn;
    }

    public void setHoursToTurn(Integer hoursToTurn) {
        this.hoursToTurn = hoursToTurn;
    }

    public Magnitude getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(Magnitude magnitude) {
        this.magnitude = magnitude;
    }

    public Date getReleasedOn() {
        return releasedOn;
    }

    public void setReleasedOn(Date releasedOn) {
        this.releasedOn = releasedOn;
    }

    public String[] getCapitals() {
        return capitals;
    }

    public void setCapitals(String[] capitals) {
        this.capitals = capitals;
    }
}
