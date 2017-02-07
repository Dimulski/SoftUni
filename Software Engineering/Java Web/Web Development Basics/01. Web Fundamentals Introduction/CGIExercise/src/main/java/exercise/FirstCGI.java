package exercise;

public class FirstCGI {

    public static void main(String[] args) {
        setContentType();
        setHtmlBody();
    }

    public static void setContentType() {
        String contentType = "Content-type: text/html \n";
        System.out.println(contentType);
    }

    public static void setHtmlBody() {
        String body = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "    <head>\n" +
                "        <meta charset=\"UTF-8\">\n" +
                "        <title>Title</title>\n" +
                "    </head>\n" +
                "    <body>\n" +
                "        <div>Im a div</div>\n" +
                "    <img src=\"/images/astra.jpg\"/>\n" +
                "    </body>\n" +
                "</html>";
        System.out.println(body);
    }
}
