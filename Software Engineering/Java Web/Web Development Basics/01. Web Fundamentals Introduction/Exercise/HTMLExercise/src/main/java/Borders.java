public class Borders {

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
                        "        <title>Borders</title>\n" +
                        "    </head>\n" +
                        "    <body>\n" +
                        "    <p style=\"border-radius: 6px; border: 2px solid red; background-color: lightgrey; " +
                        "text-align: center\">\n" +
                        "        <span style=\"color: red\">Red</span> Border</p>\n" +
                        "    <p style=\"border-radius: 6px; border: 2px solid green; background-color: lightgrey; " +
                        "text-align: center\">\n" +
                        "        <span style=\"color: green\">Green</span> Border</p>\n" +
                        "    <p style=\"border-radius: 6px; border: 2px solid blue; background-color: lightgrey; " +
                        "text-align: center\">\n" +
                        "        <span style=\"color: blue\">Blue</span> Border</p>\n" +
                        "    </body>\n" +
                        "</html>";
        System.out.println(body);
    }
}
