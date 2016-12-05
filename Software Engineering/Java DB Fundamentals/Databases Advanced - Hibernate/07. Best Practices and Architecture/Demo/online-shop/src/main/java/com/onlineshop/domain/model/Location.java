package com.onlineshop.domain.model;

import java.util.Random;

public final class Location {

    private float latitude;

    private float longitude;

    public Location() {
        Random randomGenerator = new Random();
        this.latitude = randomGenerator.nextFloat();
        this.longitude = randomGenerator.nextFloat();
    }

    public float getLatitude() {
        return this.latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return this.longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
}
