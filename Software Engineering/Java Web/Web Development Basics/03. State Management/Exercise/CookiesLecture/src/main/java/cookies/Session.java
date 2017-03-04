package cookies;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Session {

    private long id;

    private Map<String, String> pairs;

    private Date createdOn;

    private Date expiresOn;

    public Session(long id) {
        this.id = id;
        this.pairs = new HashMap<>();
        this.createdOn = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(this.createdOn);
        calendar.add(Calendar.YEAR, 1);
        this.expiresOn = calendar.getTime();
    }
}
