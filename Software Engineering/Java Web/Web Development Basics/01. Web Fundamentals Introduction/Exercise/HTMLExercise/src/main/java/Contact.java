public class Contact {

    public static void main(String[] args) {
        setContentType();
        setHtmlBody();
    }

    public static void setContentType() {
        String contentType = "Content-type: text/html \n";
        System.out.println(contentType);
    }

    public static void setHtmlBody() {
        String body =
                "<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "    <head>\n" +
                        "        <meta charset=\"UTF-8\">\n" +
                        "        <title>Contact</title>\n" +
                        "    </head>\n" +
                        "    <body>\n" +
                        "        <h1>Contact Us</h1>\n" +
                        "        <form>\n" +
                        "            <label>First name: </label>\n" +
                        "            <input type=\"text\" name=\"firstName\"/>\n" +
                        "            <br/>\n" +
                        "            <label>Second name: </label>\n" +
                        "            <input type=\"text\" name=\"secondName\"/>\n" +
                        "            <br/>\n" +
                        "            <input type=\"submit\", value=\"Submit\"/>\n" +
                        "        </form>\n" +
                        "    </body>\n" +
                        "</html>";
        System.out.println(body);
    }
}
