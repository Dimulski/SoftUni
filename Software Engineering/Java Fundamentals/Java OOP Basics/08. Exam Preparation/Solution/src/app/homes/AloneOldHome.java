package app.homes;

import app.people.Person;

/**
 * Created by RoYaL on 7/6/2016.
 */
public class AloneOldHome extends Home {

    private static final int ROOMS_COUNT = 1;
    private static final int ROOMS_CONSUMPTION = 15;

    public AloneOldHome(Person foreverAlone) {
        super();

        this.people.add(foreverAlone);
    }

    @Override
    public void addRooms() {
        this.addRooms(ROOMS_COUNT, ROOMS_CONSUMPTION);
    }
}
