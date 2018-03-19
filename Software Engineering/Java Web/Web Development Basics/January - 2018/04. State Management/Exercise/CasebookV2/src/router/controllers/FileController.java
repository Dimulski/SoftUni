package router.controllers;

import enums.StatusCode;
import http.HttpResponse;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

import static router.controllers.ErrorController.ERROR_PAGE_PATH;

public class FileController implements Controller {

    private String path;
    private HttpResponse response;

    public FileController(String url, HttpResponse response) {
        this.path = url;
        this.response = response;
    }

    @Override
    public boolean trigger() {
        try {
            this.response.setContent(
                    Files.readAllBytes(
                            Paths.get(path)));
            this.response.setStatusCode(StatusCode.OK);
            return true;
        } catch (NoSuchFileException ex) {
            this.response.setStatusCode(StatusCode.BAD_REQUEST);

            try {
                this.response.setContent(Files.readAllBytes(
                        Paths.get(ERROR_PAGE_PATH)));
            } catch (IOException e) {
                e.printStackTrace();
            }

            ex.printStackTrace();
            return false;
        } catch (AccessDeniedException ex) {
            this.response.setStatusCode(StatusCode.UNAUTHORIZED);

            try {
                this.response.setContent(Files.readAllBytes(
                        Paths.get(ERROR_PAGE_PATH)));
            } catch (IOException e) {
                e.printStackTrace();
            }

            ex.printStackTrace();
            return false;
        } catch (IOException ex) {
            this.response.setStatusCode(StatusCode.BAD_REQUEST);

            try {
                this.response.setContent(Files.readAllBytes(
                        Paths.get(ERROR_PAGE_PATH)));
            } catch (IOException e) {
                e.printStackTrace();
            }

            ex.printStackTrace();
            return false;
        }
    }
}
