package http;

import enums.StatusCode;

import java.util.HashMap;

public interface HttpResponse {

    HashMap<String, String> getHeaders();

    StatusCode getStatusCode();

    byte[] getContent();

    byte[] getBytes();

    void setProtocol(String protocol);

    void setStatusCode(StatusCode statusCode);

    void setRequestUrl(String requestUrl);

    void setContent(byte[] content);

    void addHeader(String header, String value);
}
