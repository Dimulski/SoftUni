package app.domain.models;

import java.io.Serializable;
import java.util.Random;

public final class Location implements Serializable {

    private float latitude;

    private float longitude;

    public Location() {
        Random randomGenerator = new Random();
        this.latitude = randomGenerator.nextFloat();
        this.longitude = randomGenerator.nextFloat();
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }
}
