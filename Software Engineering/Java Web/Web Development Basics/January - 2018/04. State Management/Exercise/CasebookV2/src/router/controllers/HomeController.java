package router.controllers;

import enums.StatusCode;
import http.HttpResponse;
import router.ViewPaths;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class HomeController implements Controller {

    private HttpResponse response;

    public HomeController(HttpResponse response) {
        this.response = response;
    }

    @Override
    public boolean trigger() {
        this.response.setStatusCode(StatusCode.OK);
        try {
            this.response.setContent(Files.readAllBytes(Paths.get(ViewPaths.INDEX_PAGE_PATH)));
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
