package softuni.areas.tasks.utils;

import java.util.concurrent.TimeUnit;

public class Time {

    public static Long toMillis(Integer hour, Integer minutes) {
        return TimeUnit.HOURS.toMillis(hour) + TimeUnit.MINUTES.toMillis(minutes);
    }
}
