package bythecake;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BrowseCakes {
    public static void main(String[] args) throws IOException {
        Map<String, String> cakes = new HashMap<>();
        BufferedReader in = new BufferedReader(new FileReader("database.csv"));
        String line;
        while((line = in.readLine()) != null) {
            String[] pair = line.split(",");
            cakes.put(pair[0], pair[1]);
        }

        String type = "Content-Type: text/html"
                + System.lineSeparator();

        String output =
                ""
                        + "<html"
                        + HtmlElements.HEADER_ELEMENT
                        + "<body>"
                        + "<a href=\"/cgi-bin/menu.cgi\">Back to Menu</a>"
                        + "<h2>Browse Cakes</h2>";

        output +=
                ""
                        + "<form method=\"post\">"
                        + "<label>Name: </label>"
                        + "<input type=\"text\" name=\"name\"/>"
                        + "<input type=\"submit\" value=\"Search\"/>"
                        + "</form>";

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String cakeName = sc.nextLine().split("=")[1].replace('+', ' ');
            String cakePrice = cakes.get(cakeName);
            if (cakePrice == null) {
                output += ""
                        + "No such cake in database.<br/>";
            } else {
                output += ""
                        + "Name: " + cakeName + " Price: " + cakePrice + "<br/>";
            }
            in.close();
        }


        output +=
                HtmlElements.FOOTER_ELEMENT
                        + "</body>"
                        + "</html>";

        System.out.println(type);
        System.out.println(output);
    }
}
