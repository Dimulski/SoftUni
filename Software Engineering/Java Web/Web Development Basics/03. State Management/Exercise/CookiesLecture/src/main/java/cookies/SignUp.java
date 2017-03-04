package cookies;

import java.io.*;
import java.util.Map;

public class SignUp {

    public static void main(String[] args) throws IOException {
        setHtml();
    }

    public static void setHeader(String location) {
        System.out.print("Content-type: text/html\n");
        if (location != null) {
            System.out.print("Location: " + location + "\n");
        }

        System.out.print("\n");
    }

    public static void setHtml() throws IOException {
        Map<String, String> parameters = WebUtils.getParameters();


        String username = parameters.get("username");
        String password = parameters.get("password");
        User user = new User(username, password);
        if (parameters.containsKey("signup")) {
            try (
                    BufferedWriter bfw = new BufferedWriter(new FileWriter("C:\\Apache24\\cgi-bin\\myuser"))
            ) {
                bfw.write(username + "," + password);
            }

            setHeader("http://localhost:180/cgi-bin/signindemo.cgi");
        } else {
            setHeader(null);
        }

        String html = WebUtils.readWholeFile("C:\\Users\\Codex\\Documents\\MCP\\SoftUni\\Software Engineering\\Java " +
                "Web\\Web Development Basics\\03. State " +
                "Management\\Exercise\\CookiesLecture\\src\\main\\resources\\html\\signup.html");
        System.out.println(html);
    }
}