package cakeWebSite.exercise11;

        import java.io.*;
        import java.math.BigDecimal;
        import java.util.LinkedHashMap;
        import java.util.Map;
        import java.util.StringTokenizer;

public class CakeWebSiteAddCake {
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
        String header = "<html><body>";
        System.out.println(header);
    }

    private static void setBody() {
        String body =
                "<form method=\"POST\">" +
                        "Name: <input type=\"text\" name=\"name\">" +
                        "Price: <input type=\"text\" name=\"price\">" +
                        "<input type=\"submit\" value=\"Create\">";
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
        for (Map.Entry<String, String> stringStringEntry : parameterMap.entrySet()) {
            System.out.println("<bg/><p>" + stringStringEntry.getKey() + ": ");
            System.out.println(stringStringEntry.getValue() + "</p>");
        }

        String name = parameterMap.get("name");
        BigDecimal price = new BigDecimal(parameterMap.get("price"));
        Cake cake = new Cake(name, price);
    }
}
