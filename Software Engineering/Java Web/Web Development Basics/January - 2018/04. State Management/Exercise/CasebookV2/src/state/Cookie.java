package state;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Cookie {

    private Map<String, String> values;

    public Cookie() {
        this.values = new HashMap<>();
    }

    public void buildCookie(String line) {
        String[] tokens = line.split(";\\s");
        for (String token : tokens) {
            String[] attributes = token.split("=");
            this.values.put(attributes[0], attributes[1]);
        }
    }

    public void addKeyValue(String key, String value) {
        this.values.put(key, value);
    }

    public Map<String, String> getValues() {
        return values;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        Set<String> keys = this.values.keySet();
        for (String key : keys) {
            builder.append(String.format("%s=%s; ",
                    key,
                    this.values.get(key)));
        }
        return builder.toString();
    }
}

