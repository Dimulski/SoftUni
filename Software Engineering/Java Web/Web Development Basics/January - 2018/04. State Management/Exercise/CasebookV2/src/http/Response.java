package http;

import enums.StatusCode;

import java.util.HashMap;
import java.util.Set;

public class Response implements HttpResponse {

    private StatusCode statusCode;
    private String protocol;
    private HashMap<String, String> headers;
    private byte[] content;

    public Response() {
        this.headers = new HashMap<>();
    }

    @Override
    public HashMap<String, String> getHeaders() {
        return this.headers;
    }

    @Override
    public StatusCode getStatusCode() {
        return this.statusCode;
    }

    @Override
    public byte[] getContent() {
        return this.content;
    }

    @Override
    public byte[] getBytes() {
        String firstLine = String.format("%s %d %s",
                this.protocol,
                this.statusCode.getCode(),
                this.statusCode.getClass().getSimpleName());

        StringBuilder headers = new StringBuilder();
        headers.append(firstLine).append(System.lineSeparator());

        Set<String> keys = this.headers.keySet();
        for (String key : keys) {
            headers.append(String.format("%s: %s", key, this.headers.get(key)))
                    .append(System.lineSeparator());
        }
        headers.append(System.lineSeparator());

        byte[] headersDataArray = headers.toString().getBytes();
        int headersDataLength = headersDataArray.length;
        int contentLength = this.content.length;

        byte[] fullResponse = new byte[headersDataLength + contentLength];

        for (int i = 0; i < headersDataLength; i++) {
            fullResponse[i] = headersDataArray[i];
        }

        for (int i = 0; i < contentLength; i++) {
            fullResponse[i + headersDataLength] = this.content[i];
        }

        return fullResponse;
    }

    @Override
    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    @Override
    public void setStatusCode(StatusCode statusCode) {
        this.statusCode = statusCode;
    }

    @Override
    public void setContent(byte[] content) {
        this.content = content;
    }

    @Override
    public void addHeader(String header, String value) {
        this.headers.put(header, value);
    }
}
