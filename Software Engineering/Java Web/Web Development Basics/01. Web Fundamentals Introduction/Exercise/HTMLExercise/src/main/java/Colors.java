public class Colors {

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
                        "        <title>Colors</title>\n" +
                        "    </head>\n" +
                        "    <body>\n" +
                        "        <p>Once the <span style=\"color: blue\">blue plum</span> met the <span " +
                        "style=\"color: red\">red tomato</span>\n" +
                        "        playing with the <span style=\"color: green\">green cucumber</span>.</p>\n" +
                        "    </body>\n" +
                        "</html>";
        System.out.println(body);
    }
}
