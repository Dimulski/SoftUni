package softuni.server.http;

import java.util.Map;

public interface HttpRequest {

    String getUrl();

    String getPath();

    HttpRequestMethod getRequestType();

    String getHeader(String name);

    Map<String, String> getURLParameters();

    Map<String, String> getQueryParameters();

    Map<String, String> getFormData();

    void addParameter(String name, String value);
}
