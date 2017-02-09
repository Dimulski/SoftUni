package cakeWebSite.exercise15;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Login {
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
        String header = "<head>" +
                "<style>" +
                "label{\n" +
                "    display: inline-block;\n" +
                "    float: left;\n" +
                "    clear: left;\n" +
                "    width: 70px;\n" +
                "    text-align: right;\n" +
                "}\n" +
                "input {\n" +
                "  display: inline-block;\n" +
                "  float: left;\n" +
                "}" +
                "#btn {" +
                "margin-left: 161px;" +
                "}" +
                "</style>" +
                "</head><html><body>";
        System.out.println(header);
    }

    private static void setBody() {
        String body =
                "<form method=\"POST\">" +
                        "<label>Username: </label> <input type=\"text\" name=\"username\">" +
                        "<br/><label>Password: </label><input type=\"text\" name=\"password\">" +
                        "<br/><input id=\"btn\" type=\"submit\" value=\"Login\">" +
                        "</form>";
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
        String username = parameterMap.get("username");
        String password = parameterMap.get("password");
        if(!username.equals("null")) {
            System.out.println("<br/><p>Hi " + username + ", your password is " + password + "</p?");
        }
    }
}
