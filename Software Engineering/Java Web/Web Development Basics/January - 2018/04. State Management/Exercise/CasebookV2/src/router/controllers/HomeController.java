package router.controllers;

import enums.StatusCode;
import http.HttpResponse;
import router.ViewPaths;
import state.Session;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HomeController implements Controller {

    private HttpResponse response;
    private Session session;

    public HomeController(HttpResponse response, Session session) {
        this.response = response;
        this.session = session;
    }

    @Override
    public boolean trigger() {
        this.response.setStatusCode(StatusCode.OK);

//        if (this.session.getCookie().getValues != null) {
//            System.out.println("thonking");
//        }


        try {
            this.response.setContent(Files.readAllBytes(Paths.get(ViewPaths.INDEX_PAGE_PATH)));
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
