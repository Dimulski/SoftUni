package bythecake;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;


public class AddCake {

    public static void main(String[] args) throws FileNotFoundException {
        String type = "Content-Type: text/html"
                + System.lineSeparator();

        String output =
                ""
                        + "<html"
                        + HtmlElements.HEADER_ELEMENT
                        + "<body>"
                        + "<a href=\"/cgi-bin/menu.cgi\">Back to Menu</a>"
                        + "<h2>Add Cake</h2>";

////        output += System.getenv().get("QUERY_STRING");
//        for (Map.Entry<String, String> envs : System.getenv().entrySet()) {
//            output += (envs.getKey() + " ==> " + envs.getValue() + "<br/>");
//        }

        output +=
                ""
                        + "<form method=\"post\">"
                        + "<label>Name: </label>"
                        + "<input type=\"text\" name=\"name\"/>"
                        + "<label>Price: </label>"
                        + "<input type=\"text\" name=\"price\"/>"
                        + "<input type=\"submit\" value=\"Submit\"/>"
                        + "</form>";

        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String[] paramPairs = sc.nextLine().split("&");
            String name = paramPairs[0].split("=")[1];
            String price = paramPairs[1].split("=")[1];
            writeToDatabase(name, price);
            output += ""
                        + "Name: " + name + "<br/>"
                        + "Price: " + price + "<br/>";
        }

        output +=
                HtmlElements.FOOTER_ELEMENT
                        + "</body>"
                        + "</html>";

        System.out.println(type);
        System.out.println(output);
    }

    public static void writeToDatabase(String name, String price) throws FileNotFoundException {
        PrintWriter pw = new PrintWriter(new File("cakedatabase.txt"));
        StringBuilder sb = new StringBuilder();
        sb.append(name + "," + price + "\n");

        pw.write(sb.toString());
        pw.close();
    }
}