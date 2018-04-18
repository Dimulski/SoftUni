package org.softuni.main.casebook.handlers.dynamic;

import org.softuni.main.casebook.handlers.BaseHandler;
import org.softuni.main.casebook.utilities.TemplateEngine;
import org.softuni.main.database.models.User;
import org.softuni.main.database.repositories.UserRepository;
import org.softuni.main.javache.WebConstants;
import org.softuni.main.javache.http.*;

import javax.persistence.EntityManagerFactory;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

abstract class BaseDynamicHandler extends BaseHandler {
    private static final String VIEWS_FULL_PATH =
            System.getProperty("user.dir")
                    + "\\src\\org\\softuni\\main\\casebook\\resources\\templates\\";

    private static final String BASE_VIEW_FULL_PATH =
            System.getProperty("user.dir")
                    + "\\src\\org\\softuni\\main\\casebook\\resources\\base-template.html";

    private static final String HEADER_VIEW_FULL_PATH =
            System.getProperty("user.dir")
                    + "\\src\\org\\softuni\\main\\casebook\\resources\\headers\\";

    private static final String VIEWS_EXTENSION = ".html";

    private static final TemplateEngine TEMPLATE_ENGINE = new TemplateEngine();

    protected EntityManagerFactory entityManagerFactory;

    protected final Map<String, String> viewData;

    protected BaseDynamicHandler(HttpSessionStorage sessionStorage, EntityManagerFactory entityManagerFactory) {
        super(sessionStorage);
        this.viewData = new HashMap<>();
        this.entityManagerFactory = entityManagerFactory;
    }

    private String getBaseView() {
        try {
            List<String> content =
                    Files.readAllLines(Paths.get(
                            BASE_VIEW_FULL_PATH));
            return String.join("", content);
        } catch (IOException e) {
            return null;
        }
    }

    private String getHeaderView(String view) {
        try {
            List<String> content =
                    Files.readAllLines(Paths.get(
                            HEADER_VIEW_FULL_PATH
                                    + view
                                    + VIEWS_EXTENSION));
            return String.join("", content);
        } catch (IOException e) {
            return null;
        }
    }

    private String getHeaderContent(HttpRequest request) {
        if (this.isLoggedIn(request)) {
            return this.getHeaderView("header-user");
        } else {
            return this.getHeaderView("header-guest");
        }
    }

    private String getView(String viewName) {
        try {
            List<String> content =
                    Files.readAllLines(Paths.get(
                            VIEWS_FULL_PATH
                                    + viewName
                                    + VIEWS_EXTENSION));
            return String.join("", content);
        } catch (IOException e) {
            return null;
        }
    }

    protected User getCurrentUser(HttpRequest request, UserRepository userRepository) {
        HttpCookie cookie = request.getCookies().get(WebConstants.SERVER_SESSION_TOKEN);
        String userId = this.sessionStorage
                .getSession(cookie.getValue())
                .getAttributes()
                .get("user-id")
                .toString();

        User user = (User) userRepository.doAction("findById", userId);

        return user;
    }

    protected HttpResponse view(String view, HttpRequest request, HttpResponse response) {
        String baseViewContent = this.getBaseView();
        String headerContent = this.getHeaderContent(request);

        String viewContent = this.getView(view);
        String renderedContent = TEMPLATE_ENGINE.renderHtml(viewContent == null ? "" : viewContent, this.viewData);

        baseViewContent = baseViewContent.replace("$(header)", headerContent == null ? "" : headerContent);
        String fullViewContent = baseViewContent.replace("$(view)", renderedContent == null ? "" : renderedContent);

        if (viewContent == null) {
            return this.notFound(request, response);
        }

        response.setStatusCode(HttpStatus.OK);
        response.addHeader("Content-Type", "text/html");
        response.setContent(fullViewContent.getBytes());

        this.viewData.clear();

        return response;
    }

    protected HttpResponse redirect(String location, HttpRequest request, HttpResponse response) {
        response.setStatusCode(HttpStatus.SEE_OTHER);
        response.addHeader("Location", location);

        return response;
    }
}
