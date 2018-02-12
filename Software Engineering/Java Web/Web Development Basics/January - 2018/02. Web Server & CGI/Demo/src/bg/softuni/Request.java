package bg.softuni;

import java.util.HashMap;
import java.util.Map;

public class Request {
    public static Map<String, String> createParameterMap(String params) {
        Map<String, String> requestParams = new HashMap<>();
        if (params == null || params.trim().isEmpty()) {
            return requestParams;
        }
        for (String pairString : params.split("&")) {
            String[] pair = pairString.split("=");
            requestParams.put(pair[0], pair[1]);
        }

        return requestParams;
    }
}
