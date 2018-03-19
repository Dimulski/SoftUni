package router.controllers;

import database.Database;
import enums.StatusCode;
import http.HttpRequest;
import http.HttpResponse;
import models.User;
import router.ViewPaths;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

public class RegisterController implements Controller {


    private HttpRequest request;
    private HttpResponse response;

    public RegisterController(HttpRequest request, HttpResponse response) {
        this.request = request;
        this.response = response;
    }

    private void goToRegisterPage() throws IOException {
        this.response.setContent(
                Files.readAllBytes(
                        Paths.get(ViewPaths.REGISTER_PAGE_PATH)));
    }

    @Override
    public boolean trigger() {
        if (this.request.getMethod().equals("GET")) {
            try {
                this.response.setStatusCode(StatusCode.OK);
                this.response.addHeader("Content-Type", "text/html");
                goToRegisterPage();

                return true;
            } catch (IOException e) {
                this.response.setStatusCode(StatusCode.BAD_REQUEST);
                e.printStackTrace();
                return false;
            }
        } else if (this.request.getMethod().equals("POST")) {
            this.response.setStatusCode(StatusCode.OK);
            this.response.addHeader("Content-Type", "text/html");

            String email = null;
            try {
                email = URLDecoder.decode(this.request.getBodyParameters().get("email"), "utf-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }

            User user = Database.find(email);
            if (user == null) {
                String username = this.request.getBodyParameters().get("username");
                String password = this.request.getBodyParameters().get("password");
                String confirmPassword = this.request.getBodyParameters().get("confirmPassword");
                try {
                    if (!password.equals(confirmPassword)) {
                        goToRegisterPage();
                    } else {
                        user = new User(username, password, email);
                        user.setId(UUID.randomUUID().toString());
                        Database.save(user);
                        this.response.setContent(
                                Files.readAllBytes(
                                        Paths.get(ViewPaths.LOGIN_PAGE_PATH)));
                        return true;
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            } else {
                try {
                    goToRegisterPage();
                } catch (IOException e) {
                    e.printStackTrace();
                    return false;
                }
            }
        }
        return false;
    }
}
