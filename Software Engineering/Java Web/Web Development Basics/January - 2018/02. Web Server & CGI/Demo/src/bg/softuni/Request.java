package bg.softuni;

import java.util.HashMap;
import java.util.Map;

public class Request {
    public static Map<String, String> getCookieMap(String cookieString) {
        Map<String, String> cookieMap = new HashMap<>();
        if (cookieString == null || cookieString.trim().isEmpty()) {
            return cookieMap;
        }
        for (String pairString : cookieString.split("; ")) {
            String[] pair = pairString.split("=");
            cookieMap.put(pair[0], pair[1]);
        }

        return cookieMap;
    }

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
