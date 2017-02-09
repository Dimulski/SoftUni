public class Headings {

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
                        "        <title>Headings</title>\n" +
                        "    </head>\n" +
                        "    <body>\n" +
                        "        <h1>Headings Exercise</h1>\n" +
                        "        <h2>First Heading (Bigger)</h2>\n" +
                        "        <h3>Second Heading (Smaller)</h3>\n" +
                        "        <h4>Third Heading (Even Smaller)</h4>\n" +
                        "        <h5>Fourth Heading (Smallest)</h5>\n" +
                        "    </body>\n" +
                        "</html>";
        System.out.println(body);
    }
}
