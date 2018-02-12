package bg.softuni;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Content-type: text/html");
        if (!System.getenv("REQUEST_METHOD").equals("POST")) {
            System.out.println();
            System.out.println("You cannot call register without post");
            return;
        }
        Scanner sc = new Scanner(System.in);
//        String a = sc.nextLine();
//        System.out.println();
//        System.out.println(a);
//        System.exit(0);
//        Map<String, String> getParams = createParameterMap(System.getenv("QUERY_STRING"));
        Map<String, String> postParams = Request.createParameterMap(sc.nextLine());

        if (!postParams.containsKey("register_btn")) {
            System.out.println();
            System.out.println("You have to click the register button");
            return;
        }

        String username = postParams.get("username");
        String password = postParams.get("password");
        String confirm = postParams.get("confirm");

        if (!password.equals(confirm)) {
            System.out.println();
            System.out.println("Passwords mismatch!");
            return;
        }

        BufferedReader fr = new BufferedReader(new FileReader("users.txt"));
        long count = fr.lines().count();
        long id = count + 1;
        fr.close();
        FileWriter fw = new FileWriter("users.txt", true);
        fw.append(String.valueOf(id))
                .append("|")
                .append(username)
                .append("|")
                .append(password)
                .append("\r\n");
        fw.flush();
        fw.close();

        System.out.println("Location: users.cgi");
        System.out.println();
    }
}
