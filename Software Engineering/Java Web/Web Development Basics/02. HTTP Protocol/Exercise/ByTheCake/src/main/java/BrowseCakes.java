import java.io.*;
import java.math.BigDecimal;
import java.util.*;

public class BrowseCakes {

    public static void main(String[] args) {
        setType();
        setHeader();
        setBody();
        setFooter();
        readParameters();
    }

    private static void setType() {
        String type = "Content-Type: text/html\n";
        System.out.println(type);
    }

    private static void setHeader() {
        String header = "<html><body>" +
                "<p><a href = \"invoker.cgi\">Back to home<a></p>";
        System.out.println(header);
    }

    private static void setBody() {
        String body =
                "<form method=\"GET\">" +
                        "<input type=\"text\" name=\"name\">" +
                        "<input type=\"submit\" value=\"Search\">";
        System.out.println(body);
    }

    private static void setFooter() {
        String footer = "</body></html>";
        System.out.println(footer);
    }

    private static boolean isPost() {
        String requestMethod = System.getProperty("cgi.request_method");
        boolean isPost = false;
        if (requestMethod.equals("post") || requestMethod.equals("POST")) {
            isPost = true;
        }

        return isPost;
    }

    private static Map<String, String> getParameters(InputStream inputStream) {
        Map<String, String> parametersMap = new LinkedHashMap();
        String inBuffer = "";
        if (isPost()) {
            DataInput dataInput = new DataInputStream(inputStream);
            String line;
            try {
                while ((line = dataInput.readLine()) != null) {
                    inBuffer += line;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            inBuffer = System.getProperty("cgi.query_string");
        }

        StringTokenizer parameters = new StringTokenizer(inBuffer.replace("+", " "), "&");
        while (parameters.hasMoreTokens()) {
            String pair = parameters.nextToken();
            StringTokenizer pairs = new StringTokenizer(pair, "=");
            while (pairs.hasMoreTokens()) {
                String key = pairs.nextToken();
                String value = pairs.nextToken();
                parametersMap.put(key, value);
            }
        }

        return parametersMap;
    }

    private static void readParameters() {
        Map<String, String> parameterMap = getParameters(System.in);
        String name = parameterMap.get("name");
        List<Cake> cakes = new ArrayList();
        try (
                BufferedReader br
                        = new BufferedReader(
                        new FileReader("C:\\Apache24\\cgi-bin\\WebFundamentals\\ByTheCake\\database.csv"));
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] tokens = line.split(",");
                String cakeName = tokens[0];
                BigDecimal cakePrice = new BigDecimal(tokens[1]);
                Cake cake = new Cake(cakeName, cakePrice);
                cakes.add(cake);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        cakes.stream().forEach(c -> {
            String cakeName = c.getName();
            BigDecimal cakePrice = c.getPrice();
            if(cakeName.toLowerCase().contains(name.toLowerCase())){
                System.out.println("<p>Name: "+cakeName+" Price: " + cakePrice +"</p>");
            }
        });
    }
}
