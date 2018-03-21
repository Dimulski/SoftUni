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

public class ProfileController implements Controller {

    private Session session;
    private HttpRequest request;
    private HttpResponse response;

    public ProfileController(HttpRequest request, HttpResponse response, Session session) {
        this.request = request;
        this.response = response;
        this.session = session;
    }

    private void redirectToLogin() {
        try {
            System.out.println("request------------------- \n" + this.request);
            this.request.setRequestUrl("/login");
            System.out.println("request-------------------- \n" + this.request);

            this.response.setContent(Files.readAllBytes(
                    Paths.get(ViewPaths.LOGIN_PAGE_PATH)));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean trigger() {
        this.response.setStatusCode(StatusCode.OK);
        this.response.addHeader("Content-Type", "text/html");

        if (this.request.getHeaders().containsKey("Cookie")) {

            String sessionId = this.session.getId();
            String headerSessionId = this.request.getSessionId();

            if (sessionId.equals(headerSessionId)) {
                Cookie cookie = this.session.getCookie();

                if (cookie.getValues().containsKey("userId")) {
                    String userId = cookie.getValues().get("userId");
                    User user = Database.find(userId, true);

                    try {
                        String profilePage =
                                Reader.readAllLines(new FileInputStream(ViewPaths.PROFILE_PAGE_PATH));

                        profilePage = String.format(profilePage,
                                user.getUsername(),
                                user.getEmail(),
                                user.getPassword());

                        this.response.setContent(profilePage.getBytes());
                        this.response.addHeader("Set-Cookie", this.session.toString());

                        return true;

                    } catch (IOException e) {
                        e.printStackTrace();
                        return false;

                    }

                } else {
                    redirectToLogin();

                }
            } else {
                redirectToLogin();

            }
        } else {
            redirectToLogin();

        }
        return false;

    }
}
