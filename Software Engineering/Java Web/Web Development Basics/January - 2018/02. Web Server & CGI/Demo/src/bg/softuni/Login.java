package bg.softuni;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class Login {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        Map<String, String> postParams = Request.createParameterMap(sc.nextLine());
        String formUsername = postParams.get("username");
        String formPassword = postParams.get("password");

        BufferedReader fr = new BufferedReader(new FileReader("users.txt"));
        Optional<String> foundUser = fr.lines().filter(line -> {
            String[] userData = line.split("\\|");
            String id = userData[0];
            String username = userData[1];
            String password = userData[2];
            return username.equals(formUsername) && password.equals(formPassword);
        }).findFirst();

        System.out.println("Content-Type: text/html");
        if (foundUser.isPresent()) {
            System.out.println("Set-Cookie: username=" + foundUser.get().split("\\|")[1]);
            System.out.println("Location: /cgi-bin/secure.cgi");
            System.out.println();
            System.exit(0);
        } else {
            System.out.println();
            System.out.println();
            System.out.println("<h1>Username not found or password mismatch.</h1>");
            System.out.println("<a href='/login.html'>Go back to login</a>");
        }
    }


}
