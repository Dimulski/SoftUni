package softuni.server.handler;

import softuni.server.http.HttpContext;
import softuni.server.http.HttpSession;
import softuni.server.http.HttpSessionImpl;
import softuni.server.http.response.HttpResponse;
import softuni.server.util.SessionCreator;

import java.io.IOException;
import java.io.Writer;
import java.util.function.Function;

public abstract class RequestHandlerImpl implements RequestHandler {
    private Function<HttpContext, HttpResponse> function;
    private Writer writer;

    public RequestHandlerImpl() {
    }

    RequestHandlerImpl(Function<HttpContext, HttpResponse> function) {
        this.function = function;
    }

    private void setSession(HttpContext httpContext){

        if(!httpContext.getHttpRequest().getHttpCookie().contains("sessionId") || httpContext.getHttpRequest().getHttpSession() == null){
            String sessionId = SessionCreator.getInstance().generateSessionId();

            HttpSession httpSession = new HttpSessionImpl(sessionId);
            httpContext.getHttpRequest().setSession(httpSession);
        }
    }

    void setFunction(Function<HttpContext, HttpResponse> function) {
        this.function = function;
    }

    @Override
    public void handle(HttpContext httpContext) throws IOException {
        this.setSession(httpContext);

        HttpResponse httpResponse = function.apply(httpContext);

        if (httpContext.getHttpRequest().getHttpSession().isSet()) {
            httpResponse.addResponseHeader("Set-Cookie",
                    "sessionId=" + httpContext.getHttpRequest().getHttpSession().getId() + "; HttpOnly; path=/");
            httpContext.getHttpRequest().getHttpSession().setSet();
        }

        httpResponse.addResponseHeader("Content-Type", "text/html");
        this.writer.write(httpResponse.getResponse());
    }

    @Override
    public void setWriter(Writer writer) {
        this.writer = writer;
    }
}
