package bg.softuni.main.casebook;

import bg.softuni.main.casebook.handlers.HomeHandler;
import bg.softuni.main.javache.Application;
import bg.softuni.main.javache.http.HttpContext;
import bg.softuni.main.javache.http.HttpResponse;
import bg.softuni.main.javache.http.HttpSession;
import bg.softuni.main.javache.http.HttpStatus;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class CasebookApplication implements Application {

    private HttpSession session;
    private HashMap<String, Function<HttpContext, byte[]>> routesTable;

    public CasebookApplication() {
        this.initRoutes();
    }

    @Override
    public Map<String, Function<HttpContext, byte[]>> getRoutes() {
        return Collections.unmodifiableMap(this.routesTable);
    }

    @Override
    public byte[] handleRequest(HttpContext httpContext) {
        String requestUrl = httpContext.getHttpRequest().getRequestUrl();

        if (!this.getRoutes().containsKey(requestUrl)) {
            return this.notFound(httpContext).getBytes();
        }

        return this.getRoutes().get(requestUrl).apply(httpContext);
    }

    private HttpResponse notFound(HttpContext httpContext) {
        HttpResponse httpResponse = httpContext.getHttpResponse();

        httpResponse.setStatusCode(HttpStatus.NOT_FOUND);
        httpResponse.addHeader("Content-Type", "text/html");
        httpResponse.setContent("<h1>Error (404): The page or resource you are looking for is invalid.</h1>".getBytes());

        return httpResponse;
    }

    @Override
    public HttpSession getSession() {
        return this.session;
    }

    @Override
    public void setSession(HttpSession session) {
        this.session = session;
    }

    private void initRoutes() {
        this.routesTable = new HashMap<>();

        this.routesTable.put("/", (HttpContext httpContext) ->
                new HomeHandler().index(httpContext.getHttpRequest(), httpContext.getHttpResponse()).getBytes());
    }
}
