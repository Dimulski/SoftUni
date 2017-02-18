public class ContactUsForm2 {

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
                        "        <title>Title</title>\n" +
                        "        <link rel=\"stylesheet\" href=\"\\css\\contact-us-form-2.css\">\n" +
                        "    </head>\n" +
                        "    <body>\n" +
                        "        <form>\n" +
                        "            <div class=\"form-control\">\n" +
                        "                <span class=\"label\">First Name</span>\n" +
                        "                <input type=\"text\">\n" +
                        "            </div>\n" +
                        "            <div class=\"form-control\">\n" +
                        "                <span class=\"label\">Last Name</span>\n" +
                        "                <input type=\"text\">\n" +
                        "            </div>\n" +
                        "            <div class=\"form-control\">\n" +
                        "                <span class=\"label\">Email</span>\n" +
                        "                <input type=\"text\">\n" +
                        "            </div>\n" +
                        "            <div class=\"form-control\">\n" +
                        "                <span class=\"label\">Town:</span>\n" +
                        "                <select name=\"town\">\n" +
                        "                    <option value=\"1\">Sofia</option>\n" +
                        "                    <option value=\"2\">Plovdiv</option>\n" +
                        "                    <option value=\"3\">Copenhagen</option>\n" +
                        "                </select>\n" +
                        "            </div>\n" +
                        "            <div>\n" +
                        "                <input class=\"form-button\" type=\"submit\" value=\"Submit\">\n" +
                        "            </div>\n" +
                        "        </form>\n" +
                        "    </body>\n" +
                        "</html>";
        System.out.println(body);
    }
}
