public class Hello {

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
                        "        <title>Hello HTML</title>\n" +
                        "    </head>\n" +
                        "    <body>\n" +
                        "        <h1>Hello HTML!</h1>\n" +
                        "        <p>I am <span style=\"font-weight: bold\">George Dimulski</span>. I am from " +
                        "<a href=\"http://www.visitplovdiv.com/bg/\">Plovdiv</a>.</p>\n" +
                        "        <p>I study <span style=\"font-style: italic\">Java Web Development</span> at " +
                        "<a href=\"http://softuni.bg\">SoftUni</a>.</p>\n" +
                        "        <p>back to <a href=\"home.cgi\">home</a></p>\n" +
                        "    </body>\n" +
                        "</html>";
        System.out.println(body);
    }
}
