package softuni.app.controller;

import softuni.app.view.HomeIndexView;
import softuni.app.view.HomeListView;
import softuni.server.Model;
import softuni.server.http.HttpContext;
import softuni.server.http.HttpRequestMethod;
import softuni.server.http.HttpSession;
import softuni.server.http.response.HttpResponse;
import softuni.server.http.response.HttpResponseCode;
import softuni.server.http.response.RedirectResponse;
import softuni.server.http.response.ViewResponse;
import softuni.server.routing.Controller;
import softuni.server.routing.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @RequestMapping("/")
    public HttpResponse index(HttpContext httpContext){

        return new ViewResponse(HttpResponseCode.OK, new HomeIndexView());
    }

    @RequestMapping(value = "/", method = HttpRequestMethod.POST)
    public HttpResponse login(HttpContext httpContext) {
        HttpSession session = httpContext.getHttpRequest().getHttpSession();
        session.add("name", httpContext.getHttpRequest().getFormData().get("username"));
        session.add("list", "");

        return new RedirectResponse("/list");
    }

    @RequestMapping("/list")
    public HttpResponse listItems(HttpContext httpContext) {
        String name = httpContext.getHttpRequest().getHttpSession().get("name");
        if (null == name) {
            return new RedirectResponse("/");
        }
        String itemStr = httpContext.getHttpRequest().getHttpSession().get("list");
        List<String> elements = new ArrayList<>();
        for (String item : itemStr.split("\\[\\+\\]}")) {
            elements.add(item);
        }
        Model model = new Model();
        model.add("list", elements);
        return new ViewResponse(HttpResponseCode.OK, new HomeListView(model));
    }

    @RequestMapping(value = "/list", method = HttpRequestMethod.POST)
    public HttpResponse addItem(HttpContext httpContext) {
        String newItem = httpContext.getHttpRequest().getFormData().get("new-item");
        String itemStr = httpContext.getHttpRequest().getHttpSession().get("list");
        itemStr += "[+]" + newItem;
        httpContext.getHttpRequest().getHttpSession().add("list", itemStr );
        return new RedirectResponse("/list");
    }

    @RequestMapping(value = "/logout")
    public HttpResponse logout(HttpContext httpContext) {
        httpContext.getHttpRequest().getHttpSession().clear();
        return new RedirectResponse("/");
    }
}
