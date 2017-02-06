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
        String body = "<html>" +
                        "<body>" +
                            "<b>" +
                                "Hello from CGI!" +
                            "</b>" +
                        "</body>" +
                    "</html>";
        System.out.println(body);
    }
}
