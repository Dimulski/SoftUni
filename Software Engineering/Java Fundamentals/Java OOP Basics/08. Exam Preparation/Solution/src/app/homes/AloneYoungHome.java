package app.homes;

import app.items.Device;
import app.people.Person;

/**
 * Created by RoYaL on 7/6/2016.
 */
public class AloneYoungHome extends Home {

    private static final int ROOMS_COUNT = 1;
    private static final int ROOMS_CONSUMPTION = 10;

    public AloneYoungHome(Person partiallyAlone, Device laptop) {
        super();

        this.people.add(partiallyAlone);
        this.devices.add(laptop);
    }

    @Override
    public void addRooms() {
        this.addRooms(ROOMS_COUNT, ROOMS_CONSUMPTION);
    }
}
