package bg.softuni.main.casebook.handlers;

import bg.softuni.main.javache.http.HttpRequest;
import bg.softuni.main.javache.http.HttpResponse;
import bg.softuni.main.javache.http.HttpStatus;

public class HomeHandler {

    public HttpResponse index(HttpRequest request, HttpResponse response) {
        response.setStatusCode(HttpStatus.OK);
        response.addHeader("Content-Type", "text/html");
        response.setContent("<h1>Hello From Casebook</h1><h2>This is Home</h2>".getBytes());
        return response;
    }
}
