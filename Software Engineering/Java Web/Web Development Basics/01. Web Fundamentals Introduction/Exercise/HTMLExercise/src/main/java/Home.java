public class Home {

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
                        "        <title>Home</title>\n" +
                        "    </head>\n" +
                        "    <body>\n" +
                        "        <h1>Home</h1>\n" +
                        "        <ul>\n" +
                        "            <li><a href=\"hello.cgi\">hello.html</a></li>\n" +
                        "            <li><a href=\"todo.cgi\">todo.html</a></li>\n" +
                        "        </ul>\n" +
                        "    </body>\n" +
                        "</html>";
        System.out.println(body);
    }
}
