public class Paragraphs {

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
                        "        <title>Paragraphs</title>\n" +
                        "    </head>\n" +
                        "    <body>\n" +
                        "        <h1>Paragraphs</h1>\n" +
                        "        <h5><em>First</em> paragraph</h5>\n" +
                        "        <h5><em>Second</em> paragraph</h5>\n" +
                        "        <br/>\n" +
                        "        <h5><em>Third</em> paragraph</h5>\n" +
                        "    </body>\n" +
                        "</html>";
        System.out.println(body);
    }
}
