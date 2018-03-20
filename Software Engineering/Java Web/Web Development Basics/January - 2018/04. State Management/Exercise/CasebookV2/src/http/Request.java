package http;

import java.util.HashMap;

public final class Request implements HttpRequest {

    private String[] requestLines;
    private String[] firstLineParams;
    private String method;
    private String requestUrl;
    private String protocol;
    private HashMap<String, String> headers;
    private HashMap<String, String> bodyParameters;

    public Request(String requestContent) {
        this.headers = new HashMap<>();
        this.bodyParameters = new HashMap<>();
        this.initRequestLines(requestContent);
        this.initFirstLineParams();
        this.initMethod();
        this.initRequestUrl();
        this.initProtocol();
        this.initHeaders();
        this.initBodyParameters();
    }

    private void initRequestLines(String requestContent) {
        this.requestLines = requestContent.split("\n");
    }

    private void initFirstLineParams() {
        this.firstLineParams = this.requestLines[0].split("\\s+");
    }

    private void initMethod() {
        this.method = this.firstLineParams[0];
    }

    private void initRequestUrl() {
        this.requestUrl = this.firstLineParams[1];
    }

    private void initProtocol() {
        this.protocol = this.firstLineParams[2];
    }

    private void initHeaders() {
        int endIndex = getLineSeparatorIndex();
        if (endIndex != -1) {
            String line;
            for (int i = 1; i < endIndex; ++i) {
                line = this.requestLines[i];
                String[] split = line.split(":\\s");
                this.headers.put(split[0], split[1].trim());
            }
        }
    }

    private void initBodyParameters() {
        int startIndex = getLineSeparatorIndex();
        if (startIndex != -1 && this.requestLines.length > startIndex + 1) {
            String[] line = this.requestLines[startIndex + 1].split("&");
            for (String item : line) {
                String[] items = item.split("=");
                this.bodyParameters.put(items[0], items[1]);
            }
        }
    }

    private int getLineSeparatorIndex() {
        for (int i = 0; i < this.requestLines.length; ++i) {
            if (this.requestLines[i].equals("\r")) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public HashMap<String, String> getHeaders() {
        return this.headers;
    }

    @Override
    public HashMap<String, String> getBodyParameters() {
        return this.bodyParameters;
    }

    @Override
    public String getMethod() {
        return this.method;
    }

    @Override
    public void setMethod(String method) {
        this.method = method;
    }

    @Override
    public String getRequestUrl() {
        return this.requestUrl;
    }

    @Override
    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }

    @Override
    public String getProtocol() {
        return this.protocol;
    }

    @Override
    public void addHeader(String header, String value) {
        this.headers.put(header, value);
    }

    @Override
    public void addBodyParameter(String parameter, String value) {
        this.bodyParameters.put(parameter, value);
    }

    @Override
    public boolean isResource() {
        return this.requestUrl.contains(".");
    }

    @Override
    public String getSessionId() {
        try {
            return this.headers.get("Cookie").split("=")[1];
        } catch (NullPointerException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public String toString() {
        String str = "";
        for (String requestContentLine : requestLines) {
            str += requestContentLine + "\r\n";
        }
        return str;
    }
}
