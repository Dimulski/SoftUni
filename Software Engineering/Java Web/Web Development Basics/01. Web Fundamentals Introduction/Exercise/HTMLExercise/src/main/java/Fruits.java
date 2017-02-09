public class Fruits {

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
                        "    </head>\n" +
                        "    <body>\n" +
                        "        <h2>Fruits</h2>\n" +
                        "        <p><img src=\"/images/banana.png\" alt=\"banana\"/><img src=\"/images/orange.png\" " +
                        "alt=\"orange\"/><img src=\"/images/kiwi.png\" alt=\"kiwi\"/><img src=\"/images/kiwi.png\" " +
                        "alt=\"kiwi\"/><img src=\"/images/apple.png\" alt=\"apple\"/></p>\n" +
                        "        <p><img src=\"/images/apple.png\" alt=\"apple\"/><img src=\"/images/apple.png\" " +
                        "alt=\"apple\"/><img src=\"/images/banana.png\" alt=\"banana\"/><img src=\"/images/kiwi.png\"" +
                        " alt=\"kiwi\"/><img src=\"/images/orange.png\" alt=\"orange\"/></p>\n" +
                        "        <p><img src=\"/images/orange.png\" alt=\"orange\"/><img src=\"/images/banana.png\" " +
                        "alt=\"banana\"/><img src=\"/images/orange.png\" alt=\"orange\"/><img src=\"/images/orange" +
                        ".png\" alt=\"orange\"/><img src=\"/images/apple.png\" alt=\"apple\"/></p>\n" +
                        "    </body>\n" +
                        "</html>";
        System.out.println(body);
    }
}
