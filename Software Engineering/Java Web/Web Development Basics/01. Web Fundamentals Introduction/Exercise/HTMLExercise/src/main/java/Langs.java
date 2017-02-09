public class Langs {

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
                        "        <title>languages.html</title>\n" +
                        "        <link rel=\"stylesheet\" href=\"/css/langs.css\">\n" +
                        "    </head>\n" +
                        "    <body>\n" +
                        "        <p>Programming languages like <span class=\"lang\">PHP</span>,\n" +
                        "            <span class=\"lang\">JavaScript</span>,\n" +
                        "            <span class=\"lang\">C#</span> and\n" +
                        "            <span class=\"lang\">Java</span> are general-purpose.</p>\n" +
                        "    </body>\n" +
                        "</html>";
        System.out.println(body);
    }
}
