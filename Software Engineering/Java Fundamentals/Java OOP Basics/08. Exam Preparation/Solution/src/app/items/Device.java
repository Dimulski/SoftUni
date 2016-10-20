package app.items;

import app.homes.Home;

/**
 * Created by RoYaL on 7/6/2016.
 */
public class Device {

    private double consumption;

    public Device(double consumption) {
        this.setConsumption(consumption);
    }

    public double getConsumption() {
        return this.consumption;
    }

    private void setConsumption(double consumption) {
        this.consumption = consumption;
    }

}
