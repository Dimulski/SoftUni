package bythecake;

import java.io.*;
import java.util.Scanner;


public class AddCake {

    public static void main(String[] args) throws IOException {
        String type = "Content-Type: text/html"
                + System.lineSeparator();

        String output =
                ""
                        + "<html"
                        + HtmlElements.HEADER_ELEMENT
                        + "<body>"
                        + "<a href=\"/cgi-bin/menu.cgi\">Back to Menu</a>"
                        + "<h2>Add Cake</h2>";

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
            String name = paramPairs[0].split("=")[1].replace('+', ' ');
            String price = paramPairs[1].split("=")[1].replace('+', ' ');
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

    private static void writeToDatabase(String name, String price) throws IOException {
        FileWriter fw = new FileWriter("database.csv", true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter out = new PrintWriter(bw);
        out.println(name + "," + price);
        out.close();
    }
}