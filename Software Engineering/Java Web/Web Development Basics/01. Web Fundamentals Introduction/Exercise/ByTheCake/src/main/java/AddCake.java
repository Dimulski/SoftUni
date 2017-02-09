import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class AddCake {

    private static String cakeDatabasePath = "cakedatabase.txt";
    private static String separator = ",";

    public static void main(String[] args) {
        setContentType();
        setHtml();
        printParams();
        setFooter();
    }

    public static void setContentType() {
        String contentType = "Content-type: text/html \n";
        System.out.println(contentType);
    }

    public static void setHtml() {
        String html = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "    <head>\n" +
                "        <meta charset=\"UTF-8\">\n" +
                "        <title>Title</title>\n" +
                "    </head>\n" +
                "    <body>\n" +
                "\n" +
                "    <form method=\"get\">\n" +
                "        <label>Cake</label>\n" +
                "        <input type=\"text\" name=\"cake\"/>\n" +
                "        <label>Price</label>\n" +
                "        <input type=\"text\" name=\"price\"/>\n" +
                "        <input type=\"submit\", value=\"Submit\"/>\n" +
                "    </form>\n";
        System.out.println(html);
    }

    public static boolean isGet() {
        boolean isGet = false;
        String method = System.getProperty("cgi.request_method");
        if (method.toLowerCase().equals("get")) {
            isGet = true;
        }

        return isGet;
    }

    public static Map<String, String> getFormData() {
        Map<String, String> pairs = new HashMap();
        String queryString = "";
        if (isGet()) {
            queryString = System.getProperty("cgi.query_string");
            StringTokenizer pairTokenizer = new StringTokenizer(queryString, "&");
            while (pairTokenizer.hasMoreTokens()) {
                String pair = pairTokenizer.nextToken();
                StringTokenizer paramTokenizer = new StringTokenizer(pair, "=");
                String key = paramTokenizer.nextToken();
                String value = paramTokenizer.nextToken();
                pairs.put(key, value);
            }
        }

        return pairs;
    }

    public static void printParams() {
        Map<String, String> pairs = getFormData();
        String cakeName = pairs.get("cake");
        String cakePrice = pairs.get("price");
        System.out.println("<p>name: " + cakeName + "</p>");
        System.out.println("<p>price: " + cakePrice + "</p>");
        try {
            writeParams(cakeName, cakePrice);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeParams(String cakeName, String cakePrice) throws IOException {
        FileWriter fw = new FileWriter(new File(cakeDatabasePath), true);
        fw.append(cakeName + separator + cakePrice + System.lineSeparator());
        fw.close();
    }

    public static void setFooter() {
        String footer = "    </body>\n" +
                "</html>";
        System.out.println(footer);
    }
}
