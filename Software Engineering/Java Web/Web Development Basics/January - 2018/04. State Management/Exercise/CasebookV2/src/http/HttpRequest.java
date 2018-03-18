package http;

import java.util.HashMap;

public interface HttpRequest {

    HashMap<String, String> getHeaders();

    HashMap<String, String> getBodyParameters();

    String getMethod();

    void setMethod(String method);

    String getRequestUrl();

    void setRequestUrl(String requestUrl);

    String getProtocol();

    void addHeader(String header, String value);

    void addBodyParameter(String parameter, String value);

    boolean isResource();

    String getSessionId();
}
