package pizzamore;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Home {

    private static Map<String, String> parameters;

    private static Map<String, Cookie> cookies;

    private static Header header;

    private static SessionRepository sessionRepository;

    static {
        parameters = new HashMap<String, String>();
        cookies = new HashMap<String, Cookie>();
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

    public static void readParameters() {
        parameters = WebUtils.getParameters();
        for (String param : parameters.keySet()) {
            switch (param) {
                case "language":
                    String value = parameters.get("language");
                    setCookie("lang", value);
                    break;
                case "signin":
                    goToSignIn();
                    break;
                case "signup":
                    goToSignUp();
                    break;
            }
        }
    }

    private static void goToSignUp() {
        header.addLocation("http://localhost:180/cgi-bin/signup.cgi");
    }

    private static void goToSignIn() {
        header.addLocation("http://localhost:180/cgi-bin/signin.cgi");
    }

    private static void setCookie(String key, String value) {
        Cookie cookie = new Cookie(key, value);
        header.addCookie(cookie);
    }

    private static void readCookies(String[] args) {
        if (args.length == 0) {
            return;
        }

        for (String incomingCookie : args) {
            String[] tokens = incomingCookie.split("=");
            String key = tokens[0];
            String value = tokens[1];
            value = value.replace(";", "");
            Cookie cookie = new Cookie(key, value);
            cookies.put(key, cookie);
        }
    }

    private static void readHtml() {
        Cookie sessionCookie = cookies.get("sid");
        String username = null;
        if (sessionCookie != null) {
            long sid = Long.parseLong(sessionCookie.getValue());
            Session session = sessionRepository.findById(sid);
            //Sign Out
            if (parameters.containsKey("signout")) {
                signOut(sid);
                session = null;
            }

            if (session != null) {
                Set<SessionData> sessionData = session.getSessionData();
                for (SessionData data : sessionData) {
                    if (data.getKey().equals("username")) {
                        username = data.getValue();
                    }
                }
            }
        }

        Cookie languageCookie;
        if (!WebUtils.isPost()) {
            if (cookies.containsKey("lang")) {
                languageCookie = cookies.get("lang");
                if (languageCookie.getCookieValue().equals("DE")) {
                    readHtmlDe();
                } else {
                    readHtmlEn();
                }
            }
        } else {
            if (parameters.containsKey("language")) {
                String language = parameters.get("language");
                if (language.equals("DE")) {
                    readHtmlDe();
                } else {
                    readHtmlEn();
                }
            }
        }
    }

    private static void readHtmlDe() {
    }

    private static void readHtmlEn() {
    }

    private static void signOut(long id) {
        sessionRepository.delete(id);
    }
}
