package com.pizzamoreLab.pages;

import com.pizzamoreLab.models.cookie.Cookie;
import com.pizzamoreLab.models.header.Header;
import com.pizzamoreLab.models.session.Session;
import com.pizzamoreLab.models.session.SessionData;
import com.pizzamoreLab.repository.SessionRepository;
import com.pizzamoreLab.utils.WebUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Home {

    private static Map<String, String> parameters;

    private static Map<String, Cookie> cookies;

    private static Header header;

    private static SessionRepository sessionRepository;

    static {
        parameters = new HashMap<>();
        cookies = new HashMap();
        header = new Header();
        sessionRepository = new SessionRepository();
    }

    public static void main(String[] args) {
        //Get Cookies
        getCookies(args);
        //Get Parameters
        getPageParameters();
        //Print Header
        Home.header.printHeader();
        //Print Html
        printHtml();
    }

    private static void printHtml() {
        Cookie sessionCookie = Home.cookies.get("sid");
        String username = null;
        if(sessionCookie != null) {
            long sid = Long.parseLong(sessionCookie.getValue());
            Session session = Home.sessionRepository.getSessionById(sid);
            if(session != null) {
                Set<SessionData> sessionData = session.getSessionData();
                for (SessionData data : sessionData) {
                    if (data.getKey().equals("username")) {
                        username = data.getValue();
                    }
                }
            }
        }

        Cookie languageCookie = Home.cookies.get("lang");
        if (!WebUtils.isPost()) {
            if (languageCookie != null) {
                String language = languageCookie.getValue();
                changeLanguage(language, username);
            } else {
                changeLanguage("EN", username);
            }
        } else {
            String language = Home.parameters.get("language");
            if (language != null) {
                changeLanguage(language, username);
            } else {
                changeLanguage("EN", username);
            }
        }
    }

    private static void changeLanguage(String language, String username) {
        switch (language) {
            case "EN":
                printHtmlEn(username);
                break;
            case "DE":
                printHtmlDe(username);
                break;
        }
    }

    private static void getCookies(String[] cookies) {
        //lang=EN; sid=2
        for (String cookie : cookies) {
            String[] tokens = cookie.split("=");
            String name = tokens[0];
            String value = tokens[1].replace(";", "");
            Cookie cookieObject = new Cookie(name, value);
            Home.cookies.put(name, cookieObject);
        }
    }

    private static void getPageParameters() {
        Home.parameters = WebUtils.getParameters();

        for (String parameter : parameters.keySet()) {
            switch (parameter) {
                case "signup":
                    goToSignUp();
                    break;
                case "signin":
                    goToSignIn();
                    break;
                case "language":
                    setCookie();
                    break;
                case "signout":
                    deleteSession();
                    break;
            }
        }
    }

    private static void deleteSession() {
        Cookie sessionCookie = Home.cookies.get("sid");
        long sid = Long.parseLong(sessionCookie.getValue());
        if(sessionCookie != null){
            Home.sessionRepository.deleteSessionById(sid);
        }
    }

    private static void setCookie() {
        String languageValue = parameters.get("language");
        Cookie cookie = new Cookie("lang", languageValue);
        header.setCookie(cookie);
    }

    private static void goToSignIn() {
        Home.header.setLocation("signin.cgi");
    }

    private static void goToSignUp() {
        Home.header.setLocation("signup.cgi");
    }

    private static void printHtmlEn(String username) {
        String signButton = "Sign In";
        String signName = "signin";
        if (username != null) {
            signButton = "Sign Out(" + username + ")";
            signName = "signout";
        }

        String html = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "    <head>\n" +
                "        <meta charset=\"UTF-8\">\n" +
                "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"/>\n" +
                "        <title>Home</title>\n" +
                "        <link rel=\"stylesheet\" type=\"text/css\" href=\"/bootstrap/css/bootstrap.min.css\"/>\n" +
                "        <link rel=\"stylesheet\" type=\"text/css\" href=\"/css/home.css\"/>\n" +
                "    </head>\n" +
                "    <body>\n" +
                "        <div class=\"container-fluid\">\n" +
                "            <div id=\"myCarousel\" class=\"carousel slide\" data-ride=\"carousel\">\n" +
                "                <ol class=\"carousel-indicators\">\n" +
                "                    <li data-target=\"#myCarousel\" data-slide-to=\"0\" class=\"active\"></li>\n" +
                "                    <li data-target=\"#myCarousel\" data-slide-to=\"1\"></li>\n" +
                "                </ol>\n" +
                "                <div class=\"carousel-inner\" role=\"listbox\">\n" +
                "                    <div class=\"item active\">\n" +
                "                        <img src=\"/images/pizza_1.jpg\" alt=\"Pizza1\">\n" +
                "                    </div>\n" +
                "                    <div class=\"item\">\n" +
                "                        <img src=\"/images/pizza_2.jpg\" alt=\"Pizza2\">\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "            <nav id=\"navigation\" class=\"navbar navbar-default\">\n" +
                "                <div class=\"container\">\n" +
                "                    <div class=\"navbar-header\">\n" +
                "                        <a class=\"navbar-brand\">PizzaMore</a>\n" +
                "                    </div>\n" +
                "                    <form method=\"post\">\n" +
                "                        <input class=\"btn btn-primary\" type=\"submit\" name=\"language\" value=\"DE\"/>\n" +
                "                        <input class=\"btn btn-success\" type=\"submit\" name=\""+signName+"\" value=\"" + signButton + "\"/>\n" +
                "                        <input class=\"btn btn-warning\" type=\"submit\" name=\"signup\" value=\"Sign Up\"/>\n" +
                "                    </form>\n" +
                "                </div>\n" +
                "            </nav>\n" +
                "        </div>\n" +
                "    <script src=\"/jquery/jquery.min.js\"></script>\n" +
                "    <script src=\"/bootstrap/js/bootstrap.min.js\"></script>\n" +
                "    </body>\n" +
                "</html>";
        System.out.println(html);
    }

    private static void printHtmlDe(String username) {
        String signButton = "Anmelden";
        String signName = "signin";
        if (username != null) {
            signButton = "Abmelden(" + username + ")";
            signName = "signout";
        }
        String html = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "    <head>\n" +
                "        <meta charset=\"UTF-8\">\n" +
                "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"/>\n" +
                "        <title>Home</title>\n" +
                "        <link rel=\"stylesheet\" type=\"text/css\" href=\"/bootstrap/css/bootstrap.min.css\"/>\n" +
                "        <link rel=\"stylesheet\" type=\"text/css\" href=\"/css/home.css\"/>\n" +
                "    </head>\n" +
                "    <body>\n" +
                "        <div class=\"container-fluid\">\n" +
                "            <div id=\"myCarousel\" class=\"carousel slide\" data-ride=\"carousel\">\n" +
                "                <ol class=\"carousel-indicators\">\n" +
                "                    <li data-target=\"#myCarousel\" data-slide-to=\"0\" class=\"active\"></li>\n" +
                "                    <li data-target=\"#myCarousel\" data-slide-to=\"1\"></li>\n" +
                "                </ol>\n" +
                "                <div class=\"carousel-inner\" role=\"listbox\">\n" +
                "                    <div class=\"item active\">\n" +
                "                        <img src=\"/images/pizza_1.jpg\" alt=\"Pizza1\">\n" +
                "                    </div>\n" +
                "                    <div class=\"item\">\n" +
                "                        <img src=\"/images/pizza_2.jpg\" alt=\"Pizza2\">\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "            <nav id=\"navigation\" class=\"navbar navbar-default\">\n" +
                "                <div class=\"container\">\n" +
                "                    <div class=\"navbar-header\">\n" +
                "                        <a class=\"navbar-brand\">PizzaMore</a>\n" +
                "                    </div>\n" +
                "                    <form method=\"post\">\n" +
                "                        <input class=\"btn btn-primary\" type=\"submit\" name=\"language\" value=\"EN\"/>\n" +
                "                        <input class=\"btn btn-success\" type=\"submit\" name=\""+signName+"\" value=\"" + signButton + "\"/>\n" +
                "                        <input class=\"btn btn-warning\" type=\"submit\" name=\"signup\" value=\"Unterschreiben\"/>\n" +
                "                    </form>\n" +
                "                </div>\n" +
                "            </nav>\n" +
                "        </div>\n" +
                "    <script src=\"/jquery/jquery.min.js\"></script>\n" +
                "    <script src=\"/bootstrap/js/bootstrap.min.js\"></script>\n" +
                "    </body>\n" +
                "</html>";
        System.out.println(html);
    }
}
