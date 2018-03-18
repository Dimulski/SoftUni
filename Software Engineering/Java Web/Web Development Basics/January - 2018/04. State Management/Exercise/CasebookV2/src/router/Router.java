package router;

import http.HttpRequest;
import http.HttpResponse;
import state.Session;

public class Router {

    private Session session;
    private HttpRequest request;
    private HttpResponse response;

    public Router(HttpRequest request, HttpResponse response, Session session) {
        this.request = request;
        this.response = response;
        this.session = session;
    }

    private Controller getController() {
        switch (this.request.getRequestUrl()) {
            case "/":
            case "/index": {
                return new HomeController(this.response);
            }
            case "/login": {
                return new LoginController(this.request, this.response, this.session);
            }
            case "/register": {
                return new RegisterController(this.request, this.response);
            }
            case "/profile": {
                return new ProfileController(this.request, this.response, this.session);
            }
        }
        if (this.request.getRequestUrl().startsWith("/assets")) {
            return new FileController(ViewPaths.ASSETS_FULL_PATH + this.request.getRequestUrl(), this.response);
        }

        return new ErrorController(this.response);
    }

    public boolean execute() {
        Controller controller = getController();
        return (controller.trigger()); // ?
    }
}
