package bg.softuni.main.javache;

import bg.softuni.main.javache.http.HttpContext;
import bg.softuni.main.javache.http.HttpSession;

import java.util.Map;
import java.util.function.Function;

public interface Application {
    Map<String, Function<HttpContext, byte[]>> getRoutes();

    byte[] handleRequest(HttpContext httpContext);

    HttpSession getSession();

    void setSession(HttpSession session);
}
