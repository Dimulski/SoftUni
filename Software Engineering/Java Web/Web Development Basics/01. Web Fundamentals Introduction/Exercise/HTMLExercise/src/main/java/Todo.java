public class Todo {

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
                        "        <title>TODO List</title>\n" +
                        "    </head>\n" +
                        "    <body>\n" +
                        "        <h1>My TODO List</h1>\n" +
                        "        <ul>\n" +
                        "            <li>HTML5 course @ SoftUni</li>\n" +
                        "            <li>Homework HTML &amp; CSS</li>\n" +
                        "            <li>Teddy &ndash; birthday present</li>\n" +
                        "        </ul>\n" +
                        "        <p>back to <a href=\"home.cgi\">home</a></p>\n" +
                        "    </body>\n" +
                        "</html>";
        System.out.println(body);
    }
}
