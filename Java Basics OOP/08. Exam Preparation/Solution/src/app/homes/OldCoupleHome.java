package app.homes;

import app.items.Device;
import app.people.Person;

/**
 * Created by RoYaL on 7/6/2016.
 */
public class OldCoupleHome extends Home {

    private static final int ROOMS_COUNT = 3;
    private static final int ROOMS_CONSUMPTION = 15;

    public OldCoupleHome(Person male, Person female, Device tv, Device fridge, Device stove) {
        super();

        this.people.add(male);
        this.people.add(female);
        this.devices.add(tv);
        this.devices.add(fridge);
        this.devices.add(stove);
    }

    @Override
    public void addRooms() {
        this.addRooms(ROOMS_COUNT, ROOMS_CONSUMPTION);
    }
}
