package com.pizzamoreLab.pages;

import com.pizzamoreLab.models.cookie.Cookie;
import com.pizzamoreLab.models.header.Header;
import com.pizzamoreLab.models.session.Session;
import com.pizzamoreLab.models.user.User;
import com.pizzamoreLab.repository.SessionRepository;
import com.pizzamoreLab.repository.UserRepository;
import com.pizzamoreLab.utils.WebUtils;

import java.util.HashMap;
import java.util.Map;

public class SignIn {

    private static Map<String, String> parameters;

    private static Header header;

    private static UserRepository userRepository;

    private static SessionRepository sessionRepository;

    static {
        SignIn.parameters = new HashMap<>();
        SignIn.header = new Header();
        SignIn.userRepository = new UserRepository();
        SignIn.sessionRepository = new SessionRepository();
    }

    public static void main(String[] args) {
        //Get parameters
        readParameters();
        //Print Header
        header.printHeader();
        //Print HTML
        printHtml();
    }

    private static void printHtml() {
        String html = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"/>\n" +
                "    <title>SignIn</title>\n" +
                "    <link rel=\"stylesheet\" type=\"text/css\" href=\"/bootstrap/css/bootstrap.min.css\"/>\n" +
                "    <link rel=\"stylesheet\" type=\"text/css\" href=\"/css/signin.css\"/>\n" +
                "</head>\n" +
                "<body>\n" +
                "<div class=\"container-fluid\">\n" +
                "    <div class=\"jumbotron\">\n" +
                "        <form method=\"post\" class=\"form-horizontal\">\n" +
                "            <div class=\"form-group\">\n" +
                "                <label class=\"control-label col-sm-2 col-sm-offset-2\">Username</label>\n" +
                "                <div class=\"col-sm-3\">\n" +
                "                    <input class=\"form-control\" type=\"text\" name=\"username\">\n" +
                "                </div>\n" +
                "            </div>\n" +
                "            <div class=\"form-group\">\n" +
                "                <label class=\"control-label col-sm-2 col-sm-offset-2\">Password</label>\n" +
                "                <div class=\"col-sm-3\">\n" +
                "                    <input class=\"form-control\" type=\"password\" name=\"password\">\n" +
                "                </div>\n" +
                "            </div>\n" +
                "            <div class=\"form-group\">\n" +
                "                <div class=\"checkbox col-sm-4 col-sm-offset-4\">\n" +
                "                    <label>\n" +
                "                        <input type=\"checkbox\" name=\"rememberme\">\n" +
                "                        <span>Remember Me</span>\n" +
                "                    </label>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "            <div class=\"form-group\">\n" +
                "                <div class=\"col-sm-4 col-sm-offset-4\">\n" +
                "                    <input class=\"btn btn-success\" type=\"submit\" name=\"signin\" value=\"Sign In\"/>\n" +
                "                    <input class=\"btn btn-danger\" type=\"submit\" name=\"home\" value=\"Home\"/>\n" +
                "                </div>\n" +
                "            </div>\n" +
                "        </form>\n" +
                "    </div>\n" +
                "</div>\n" +
                "\n" +
                "<script src=\"/jquery/jquery.min.js\"></script>\n" +
                "<script src=\"/bootstrap/js/bootstrap.min.js\"></script>\n" +
                "</body>\n" +
                "</html>";

        System.out.println(html);
    }

    private static void readParameters() {
        SignIn.parameters = WebUtils.getParameters();

        for (String parameter : parameters.keySet()) {
            switch (parameter){
                case "signin":
                    boolean isSignIn = signIn();
                    redirect(isSignIn);
                    break;
                case "home":
                    goToHomePage();
                    break;
            }
        }
    }

    private static void goToHomePage() {
        SignIn.header.setLocation("home.cgi");
    }

    private static boolean signIn() {
        boolean isSignedIn = false;
        String username = parameters.get("username");
        String password = parameters.get("password");
        User user = SignIn.userRepository.findByUsernameAndPassword(username, password);
        if(user != null){
            Session userSession = new Session();
            userSession.addSessionData("username", user.getName());
            userSession.addSessionData("password", user.getPassword());
            SignIn.sessionRepository.createSession(userSession);
            Cookie cookie = new Cookie("sid", String.valueOf(userSession.getId()));
            header.setCookie(cookie);
            isSignedIn = true;
        }

        return isSignedIn;
    }

    private static void redirect(boolean isSignIn) {
        if(isSignIn){
            goToHomePage();
        }
    }
}
