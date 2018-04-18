package org.softuni.main.casebook.handlers.dynamic;

import org.softuni.main.casebook.annotations.ApplicationRequestHandler;
import org.softuni.main.casebook.annotations.Get;
import org.softuni.main.database.models.User;
import org.softuni.main.database.repositories.UserRepository;
import org.softuni.main.javache.http.HttpRequest;
import org.softuni.main.javache.http.HttpResponse;
import org.softuni.main.javache.http.HttpSessionStorage;
import org.softuni.main.javache.http.HttpStatus;

import javax.persistence.EntityManagerFactory;

@ApplicationRequestHandler
public class HomeHandler extends BaseDynamicHandler {
    protected HomeHandler(HttpSessionStorage sessionStorage, EntityManagerFactory entityManagerFactory) {
        super(sessionStorage, entityManagerFactory);
    }

    @Get(route = "/")
    public HttpResponse index(HttpRequest request, HttpResponse response) {
        return this.view("index", request, response);
    }

    @Get(route = "/home")
    public HttpResponse home(HttpRequest request, HttpResponse response) {
        if(!this.isLoggedIn(request)) {
            return this.redirect("/login", request, response);
        }

        UserRepository userRepository = new UserRepository(this.entityManagerFactory);
        User[] allUsers = (User[]) userRepository.doAction("findAll");
        StringBuilder listUsers = new StringBuilder();

        User currentUser = this.getCurrentUser(request,userRepository);

        for (User user : allUsers) {
            if(currentUser.getUsername().equals(user.getUsername())
                    || currentUser.getFriends().contains(user)) continue;

            listUsers
                    .append("<form method=\"post\" action=\"/add-friend\">")
                    .append("<div class=\"form-group row\">")
                    .append("<label class=\"col-2 col-form-label\" for=\"friendName\">" + user.getUsername() + "</label>")
                    .append("<input id=\"friendName\" type=\"hidden\" name=\"friend\" value=\"" + user.getUsername() + "\">")
                    .append("<div class=\"col-10\">")
                    .append("<button class=\"btn btn-primary\" type=\"submit\">Add Friend</button>")
                    .append("</div>")
                    .append("</div>")
                    .append("</form>");
        }

        this.viewData.putIfAbsent("people", listUsers.toString());

        userRepository.dismiss();
        return this.view("home", request, response);
    }
}
