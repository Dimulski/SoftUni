package javache.http;

import java.util.HashMap;

public class HttpRequestImpl implements HttpRequest {

    @Override
    public HashMap<String, String> getHeaders() {
        return null;
    }

    @Override
    public HashMap<String, String> getBodyParameters() {
        return null;
    }

    @Override
    public String getMethod() {
        return null;
    }

    @Override
    public void setMethod(String method) {

    }

    @Override
    public String getRequestUrl() {
        return null;
    }

    @Override
    public void setRequestUrl(String requestUrl) {

    }

    @Override
    public void addHeader(String header, String value) {

    }

    @Override
    public void addBodyParameter(String parameter, String value) {

    }

    @Override
    public boolean isResource() {
        return false;
    }
}
