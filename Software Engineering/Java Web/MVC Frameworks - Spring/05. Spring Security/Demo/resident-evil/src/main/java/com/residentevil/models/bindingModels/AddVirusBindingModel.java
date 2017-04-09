package com.residentevil.models.bindingModels;

import com.residentevil.customValidations.PresentOrFuture;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.util.Date;

public class AddVirusBindingModel {

    @NotNull
    @Size(min = 3, max = 10, message = "Invalid name")
    private String name;

    @NotNull
    @Size(min = 5, max = 300, message = "Invalid description")
    private String description;

    @NotNull
    @Size(max = 50, message = "Invalid side effects")
    private String sideEffects;

    @NotNull
    @Pattern(regexp = "^.*[Cc]orp.*$", message = "Invalid creator")
    private String creator;

    private Boolean isDeadly;

    private Boolean isCurable;

    @NotNull(message = "Mutation cannot be null")
    private String mutation;

    @Max(value = 100, message = "Invalid turnover rate")
    @Min(value = 0, message = "Invalid turnover rate")
    private float turnoverRate;

    @Max(value = 12, message = "Invalid hours")
    @Min(value = 1, message = "Invalid hours")
    private int hoursUntilTurn;

    @NotNull(message = "Magnitude cannot be null")
    private String magnitude;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PresentOrFuture(message = "The release date should be in a future moment")
    private Date releasedOn;

    @NotEmpty(message = "You must select capitals")
    private String[] capitals;

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

    public String getSideEffects() {
        return sideEffects;
    }

    public void setSideEffects(String sideEffects) {
        this.sideEffects = sideEffects;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Boolean getDeadly() {
        return isDeadly;
    }

    public void setDeadly(Boolean deadly) {
        isDeadly = deadly;
    }

    public Boolean getCurable() {
        return isCurable;
    }

    public void setCurable(Boolean curable) {
        isCurable = curable;
    }

    public String getMutation() {
        return mutation;
    }

    public void setMutation(String mutation) {
        this.mutation = mutation;
    }

    public float getTurnoverRate() {
        return turnoverRate;
    }

    public void setTurnoverRate(float turnoverRate) {
        this.turnoverRate = turnoverRate;
    }

    public int getHoursUntilTurn() {
        return hoursUntilTurn;
    }

    public void setHoursUntilTurn(int hoursUntilTurn) {
        this.hoursUntilTurn = hoursUntilTurn;
    }

    public String getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(String magnitude) {
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
