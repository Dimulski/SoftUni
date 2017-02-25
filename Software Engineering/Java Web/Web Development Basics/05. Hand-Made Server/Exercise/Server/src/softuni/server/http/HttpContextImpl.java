package softuni.server.http;

import softuni.server.exception.BadRequestException;

import java.io.UnsupportedEncodingException;

public class HttpContextImpl implements HttpContext {

    private final HttpRequestImpl httpRequest;

    public HttpContextImpl(String requestString) throws BadRequestException, UnsupportedEncodingException {
        this.httpRequest = new HttpRequestImpl(requestString);
    }

    @Override
    public HttpRequest getHttpRequest() {
        return this.httpRequest;
    }
}
