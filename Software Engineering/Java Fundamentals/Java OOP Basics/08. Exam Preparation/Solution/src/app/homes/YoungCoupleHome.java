package app.homes;

import app.Room;
import app.items.Device;
import app.people.Person;

/**
 * Created by RoYaL on 7/6/2016.
 */
public class YoungCoupleHome extends Home {

    private static final int ROOMS_COUNT = 2;
    private static final int ROOMS_CONSUMPTION = 20;

    public YoungCoupleHome(Person male, Person female, Device tv, Device fridge, Device laptop) {
        super();

        this.people.add(male);
        this.people.add(female);
        this.devices.add(tv);
        this.devices.add(fridge);
        this.devices.add(laptop);
        this.devices.add(laptop);
    }

    @Override
    public void addRooms() {
        this.addRooms(ROOMS_COUNT, ROOMS_CONSUMPTION);
    }
}
