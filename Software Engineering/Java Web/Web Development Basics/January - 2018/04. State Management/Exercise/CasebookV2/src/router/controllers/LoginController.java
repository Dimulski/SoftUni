package router.controllers;

import database.Database;
import enums.StatusCode;
import http.HttpRequest;
import http.HttpResponse;
import io.Reader;
import models.User;
import router.ViewPaths;
import state.Cookie;
import state.Session;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.UUID;

public class LoginController implements Controller {

    private Session session;
    private HttpRequest request;
    private HttpResponse response;

    public LoginController(HttpRequest request, HttpResponse response, Session session) {
        this.request = request;
        this.response = response;
        this.session = session;
    }

    @Override
    public boolean trigger() {
        if (this.request.getMethod().equals("GET")) {
            try {
                this.response.addHeader("Content-type", "text/html");
                this.response.setStatusCode(StatusCode.OK);
                redirectToLogin();
                return true;
            } catch (IOException e) {
                this.response.setStatusCode(StatusCode.BAD_REQUEST);
                e.printStackTrace();
                return false;
            }
        } else if (this.request.getMethod().equals("POST")) {
            HashMap<String, String> bodyParameters = this.request.getBodyParameters();
            if (bodyParameters.size() != 0 && bodyParameters.containsKey("submit")) {
                this.response.addHeader("Content-Type", "text/html");
                this.response.setStatusCode(StatusCode.OK);

                String username = bodyParameters.get("username");
                String password = bodyParameters.get("password");

                User user = Database.find(username, password);

                if (user == null) {
                    try {
                        this.response.setContent(Files.readAllBytes(Paths.get(ViewPaths.REGISTER_PAGE_PATH)));
                        return true;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return false;
                    }
                } else {
                    try {
                        Cookie cookie = new Cookie();
                        cookie.addKeyValue("userId", user.getId());

                        String profilePage = Reader.readAllLines(new FileInputStream(ViewPaths.PROFILE_PAGE_PATH));

                        profilePage = String.format(
                                profilePage,
                                user.getUsername(),
                                user.getEmail(),
                                user.getPassword());

                        this.session.setCookie(cookie);
                        this.session.setId(UUID.randomUUID().toString());

                        this.response.setContent(profilePage.getBytes());
                        this.response.addHeader("Set-Cookie", session.toString());

                        return true;
                    } catch (IOException e) {
                        e.printStackTrace();
                        return false;
                    }
                }
            }
        }

        return false;
    }

    private void redirectToLogin() throws IOException {
        this.response.setContent(Files.readAllBytes(Paths.get(ViewPaths.LOGIN_PAGE_PATH)));
    }
}
