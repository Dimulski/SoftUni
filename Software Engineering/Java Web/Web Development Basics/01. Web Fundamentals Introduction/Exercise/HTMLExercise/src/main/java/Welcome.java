public class Welcome {

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
                        "    <p style=\"font-size: xx-large\">I am learning <span style=\"font-weight: " +
                        "bold\">HTML</span> and <span style=\"font-weight: bold\">CSS</span>!</p>\n" +
                        "    </body>\n" +
                        "</html>";
        System.out.println(body);
    }
}
