package cakeWebSite.exercise14;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Calculator {
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
                "<form method=\"GET\">" +
                        "<input type=\"text\" name=\"num1\">" +
                        "<input type=\"text\" name=\"sign\">" +
                        "<input type=\"text\" name=\"num2\">" +
                        " =? <br/>" +
                        "<input type=\"submit\" value=\"Calculate\">" +
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
        int num1 = Integer.parseInt(parameterMap.get("num1"));
        String sign = parameterMap.get("sign");
        int num2 = Integer.parseInt(parameterMap.get("num2"));
        int result = 0;
        boolean isError = false;
        switch (sign) {
            case "+":
                result = num1 + num2;
                break;
            case "-":
                result = num1 - num2;
                break;
            case "*":
                result = num1 * num2;
                break;
            case "/":
                result = num1 / num2;
                break;
            default:
                isError = true;
                break;
        }

        if(!isError) {
            System.out.println("<p>Result: " + result + "</p>");
        } else {
            System.out.println("<p>Invalid Sign</p>");
        }
    }
}
