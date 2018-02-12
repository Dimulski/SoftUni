package bg.softuni;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

public class Users {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Content-type: text/html");
        System.out.println();

        Map<String, String> requestMap = Request.createParameterMap(System.getenv("QUERY_STRING"));
        requestMap.forEach((key, value) -> System.out.println(key + " - >" + value));
        if (requestMap.containsKey("id")) {
            String searchId = requestMap.get("id");
            BufferedReader fr = new BufferedReader(new FileReader("users.txt"));
            fr.lines().forEach(line -> {
                String[] userData = line.split("\\|");
                String id = userData[0];
                if (id.equals(searchId)) {
                    String username = userData[1];
                    String password = userData[2];
                    System.out.println("<h1>This is user " + username + "</h1>");
                    System.out.println("<i>" + password + "</i>");
                }
            });

            System.out.println("<a href='/cgi-bin/users.cgi'>Go to all users</a>");
        } else {
            System.out.println("<table border=\"1\">\n" +
                    "    <thead>\n" +
                    "    <tr>\n" +
                    "        <th>Id</th>\n" +
                    "        <th>Username</th>\n" +
                    "        <th>Password</th>\n" +
                    "    </tr>\n" +
                    "    </thead>\n" +
                    "    <tbody>");

            BufferedReader fr = new BufferedReader(new FileReader("users.txt"));
            fr.lines().forEach(line -> {
                String[] userData = line.split("\\|");
                String id = userData[0];
                String username = userData[1];
                String password = userData[2];
                System.out.println("    <tr>\n" +
                        "        <td>"+id+"</td>\n" +
                        "        <td><a href='?id="+id+"'>"+username+"</a></td>\n" +
                        "        <td>"+password+"</td>\n" +
                        "    </tr>");
            });
        }

        System.out.println("    </tbody>\n" +
                "</table>");
    }
}
