package cookies;

import java.io.*;
import java.util.Map;
import java.util.Random;

public class SignIn {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        setHtml();
    }

    public static void setHeader(String location, Cookie cookie) {
        System.out.print("Content-type: text/html\n");
        if (location != null) {
            System.out.print("Location: " + location + "\n");
        }

        if (cookie != null) {
            System.out.print("Set-Cookie: " + cookie.getCookie() + "\n");
        }

        System.out.print("\n");
    }

    public static void setHtml() throws IOException, ClassNotFoundException {
        Map<String, String> parameters = WebUtils.getParameters();

        if (parameters.containsKey("signin")) {
            String[] data = WebUtils.readWholeFile("C:\\Apache24\\cgi-bin\\myuser").split(",");
            System.out.print(data[0] + data[1]);
            User user = new User(data[0], data[1]);

            String username = parameters.get("username");
            String password = parameters.get("password");
            if (user.getName().equals(username) && user.getPassword().equals(password)) {
                createSession();
            }
        } else {
            setHeader(null, null);
        }

        String html = WebUtils.readWholeFile("C:\\Users\\Codex\\Documents\\MCP\\SoftUni\\Software Engineering\\Java " +
                "Web\\Web Development Basics\\03. State " +
                "Management\\Exercise\\CookiesLecture\\src\\main\\resources\\html\\signin.html");
        System.out.print(html);

    }

    public static void createSession() throws IOException {
        Long sessionId = new Random().nextLong();
        Session session = new Session(sessionId);
        try (
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("C:\\Apache24\\cgi-bin\\usersession.session"))
        ) {
            oos.writeObject(session);
        }

        createCookie(String.valueOf(sessionId));
    }

    public static void createCookie(String sid) {
        Cookie cookie = new Cookie("sid", sid);
        setHeader("http://localhost:180/cgi-bin/signindemo.cgi", cookie);
    }
}
