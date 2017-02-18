public class LoginForm {

    public static void main(String[] args) {
        String contentType = "Content-Type: text/html\n";
        System.out.println(contentType);
        printHeader();
        printBody();
        printFooter();
    }

    public static void printBody() {
        String title = "<h2>Login</h2><br/>";
        String body = "<form action=\"send-email.cgi\" method=\"post\">" +
                "Username: <input type=\"text\" name=\"username\"/><br/>" +
                "Password: <input type=\"password\" name=\"password\"/><br/>" +
                "<input type=\"submit\" value=\"Log In\"";
        System.out.println(title + body);
    }

    public static void printHeader() {
        System.out.println("<html><body>");
    }

    public static void printFooter() {
        System.out.println("</body></html>");
    }
}
