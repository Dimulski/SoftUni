public class Rectangles {
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
                        "        <title>Rectangles</title>\n" +
                        "    </head>\n" +
                        "    <body>\n" +
                        "        <div style=\"border-radius: 12px; border: 3px dotted blue; padding: 10px\">\n" +
                        "            <div style=\"border-radius: 6px; border: 1px dashed red; padding: 10px;\">\n" +
                        "                <div style=\"border-radius: 2px; border: 2px solid green; padding: 10px; " +
                        "text-align: center\">\n" +
                        "                    I am a heavily packed &lt;DIV&gt;\n" +
                        "                </div>\n" +
                        "            </div>\n" +
                        "        </div>\n" +
                        "    </body>\n" +
                        "</html>";
        System.out.println(body);
    }
}
