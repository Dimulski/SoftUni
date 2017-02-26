package softuni.app.controller;

import softuni.app.view.HomeIndexView;
import softuni.server.Model;
import softuni.server.http.response.HttpResponse;
import softuni.server.http.response.HttpResponseCode;
import softuni.server.http.response.ViewResponse;
import softuni.server.routing.Controller;
import softuni.server.routing.RequestMapping;
import softuni.server.routing.UriParameter;

@Controller
public class HomeController {

    @RequestMapping("/welcome/{name}")
    public HttpResponse index(@UriParameter("name") String name){
        Model model = new Model();
        model.add("name", name);

        return new ViewResponse(HttpResponseCode.OK, new HomeIndexView(model));
    }
}
