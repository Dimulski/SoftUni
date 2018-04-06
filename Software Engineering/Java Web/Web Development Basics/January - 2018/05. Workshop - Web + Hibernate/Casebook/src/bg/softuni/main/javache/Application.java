package bg.softuni.main.javache;

import bg.softuni.main.javache.http.HttpContext;
import bg.softuni.main.javache.http.HttpSession;

import java.util.HashMap;
import java.util.function.Function;

public interface Application {
    HashMap<String, Function<HttpContext, byte[]>> getRoutes();

    byte[] handleRequest(HttpContext httpContext);

    HttpSession getSession();

    void setSession(HttpSession session);
}
