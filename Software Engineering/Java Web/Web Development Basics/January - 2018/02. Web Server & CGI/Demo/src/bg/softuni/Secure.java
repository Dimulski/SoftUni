package bg.softuni;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

public class Secure {
    public static void main(String[] args) throws FileNotFoundException {

        Map<String, String> cookies = Request.getCookieMap(System.getenv("HTTP_COOKIE"));
        System.out.println("Content-type: text/html\r\n");
        if (!cookies.containsKey("username")) {
            System.out.println("<h1 style='color: red'>You cannot access this area!</h1>");
        } else {
            BufferedReader fr = new BufferedReader(new FileReader("users.txt"));
            String userInfo = fr.lines().filter(line -> {
                String[] userData = line.split("\\|");
                String username = userData[1];
                return username.equals(cookies.get("username"));
            }).findFirst().get();

            System.out.println("<h1> Hello " + cookies.get("username") + " </h1>");
            System.out.println("<h2> Your password is " + userInfo.split("\\|")[2] + "</h2>");
        }
    }
}
