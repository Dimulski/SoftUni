package http;

import java.util.HashMap;

public class Request implements HttpRequest {

//    private String[] requestLines;
//    private String[] firstLineParams;
    private String method;
    private String requestUrl;
    private String protocol;
    private HashMap<String, String> headers;
    private HashMap<String, String> bodyParameters;

    public Request(String requestContent) {
        this.headers = new HashMap<>();
        this.bodyParameters = new HashMap<>();
        this.initRequest(requestContent);
    }

    private void initRequest(String requestContent) {
        String[] requestLines = requestContent.split("\n");
        String[] firstLineParams = requestLines[0].split("\\s+");
        this.method = firstLineParams[0];
        this.requestUrl = firstLineParams[1];
        this.protocol = firstLineParams[2];
        this.initHeaders(requestLines);
        this.initBodyParameters(requestLines);
    }


    private void initHeaders(String[] requestLines) {
        int endIndex = getLineSeparatorIndex(requestLines);
        if (endIndex != -1) {
            String line;
            for (int i = 1; i < endIndex; ++i) {
                line = requestLines[i];
                String[] split = line.split(":\\s");
                this.headers.put(split[0], split[1].trim());
            }
        }
    }

    private void initBodyParameters(String[] requestLines) {
        int startIndex = getLineSeparatorIndex(requestLines);
        if (startIndex != -1 && requestLines.length > startIndex + 1) {
            String[] line = requestLines[startIndex + 1].split("&");
            for (String item : line) {
                String[] items = item.split("=");
                this.bodyParameters.put(items[0], items[1]);
            }
        }
    }

    private int getLineSeparatorIndex(String[] requestLines) {
        for (int i = 0; i < requestLines.length; ++i) {
            if (requestLines[i].equals("\r")) {
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
        StringBuilder sb = new StringBuilder();
        sb.append(this.method + " " + this.requestUrl + " " + this.protocol + "\n");
        this.getHeaders().forEach((k, v) -> {
            sb.append(k + ": " + v + "\n");
        });
        this.getBodyParameters().forEach((k, v) -> {
            sb.append(k + ": " + v + "\n");
        });

        return sb.toString();
    }
}
