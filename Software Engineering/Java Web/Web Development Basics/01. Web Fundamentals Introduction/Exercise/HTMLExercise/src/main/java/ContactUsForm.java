public class ContactUsForm {

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
                        "        <title>Contact Form</title>\n" +
                        "        <link rel=\"stylesheet\" href=\"/css/contact-us-form.css\">\n" +
                        "    </head>\n" +
                        "    <body>\n" +
                        "        <h1>Contact Us</h1>\n" +
                        "        <form>\n" +
                        "            <span>First name:</span>\n" +
                        "            <input type=\"text\" name=\"firstname\"><br/>\n" +
                        "            <span>Last name:</span>\n" +
                        "            <input type=\"text\" name=\"lastname\"><br/>\n" +
                        "            <span>Email:</span>\n" +
                        "            <input type=\"text\" name=\"email\"><br/>\n" +
                        "            <span>Town:</span>\n" +
                        "            <select name=\"town\">\n" +
                        "                <option value=\"1\">Sofia</option>\n" +
                        "                <option value=\"2\">Plovdiv</option>\n" +
                        "                <option value=\"3\">Copenhagen</option>\n" +
                        "            </select>\n" +
                        "            <input type=\"submit\" value=\"Submit\">\n" +
                        "        </form>\n" +
                        "    </body>\n" +
                        "</html>";
        System.out.println(body);
    }
}
