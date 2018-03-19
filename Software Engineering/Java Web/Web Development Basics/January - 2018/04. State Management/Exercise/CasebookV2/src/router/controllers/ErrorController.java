package router.controllers;

import enums.StatusCode;
import http.HttpResponse;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static utils.WebConstants.RESOURCES_LOCATION;

public class ErrorController implements Controller {

    public static String ERROR_PAGE_PATH = RESOURCES_LOCATION + "/pages/error.html";

    private HttpResponse response;

    public ErrorController(HttpResponse response) {
        this.response = response;
    }

    @Override
    public boolean trigger() {
        this.response.setStatusCode(StatusCode.BAD_REQUEST);
        try {
            this.response.setContent(Files.readAllBytes(
                    Paths.get(ERROR_PAGE_PATH)));
            return true;
        } catch (IOException e) {
            return false;
        }
    }
}
