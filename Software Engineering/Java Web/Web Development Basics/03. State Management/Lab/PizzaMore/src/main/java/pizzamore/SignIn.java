package pizzamore;

import java.util.HashMap;
import java.util.Map;

public class SignIn {

    private static Map<String, String> parameters;

    private static Map<String, Cookie> cookies;

    private static Header header;

    private static UserRepository userRepository;

    private static SessionRepository sessionRepository;

    static {
        parameters = new HashMap<>();
        cookies = new HashMap<>();
        header = new Header();
        userRepository = new UserRepository();
        sessionRepository = new SessionRepository();
    }

    public static void main(String[] args) {
        readParameters();
        header.printHeader();
        readHtml();
    }

    public static void readParameters() {
        parameters = WebUtils.getParameters();
        for (String param : parameters.keySet()) {
            switch (param) {
                case "signin":
                    signIn();
                    break;
                case "main":
                    goToMain();
                    break;
            }
        }
    }

    private static void signIn() {
        String username = parameters.get("username");
        String password = parameters.get("password");
        User user = userRepository.findByUserAndPassword(username, password);
        if (user != null) {
            Session session = new Session();
            session.addData("username", username);
            long sid = sessionRepository.createSession(session);
            Cookie sessionCookie = new Cookie("sid", String.valueOf(sid));
            header.addCookie(sessionCookie);
            Cookie rememberMeCookie = new Cookie("rememberme", "on");
            header.addCookie(rememberMeCookie);
            header.addLocation("http://localhost:180/cgi-bin/home.cgi");
        }
    }

    private static void goToMain() {
        header.addLocation("http://localhost:180/cgi-bin/home.cgi");
    }
}
