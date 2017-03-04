package cookies;

public class CookieDemo {

    public static void main(String[] args) {
        System.out.print("Content-type: text/html\n");
        System.out.print("Set-Cookie: " + new Cookie("lang", "en").getCookie() + "\n\n");
        System.out.print("A cookie is set");
        String incomingCookie = System.getProperty("cgi_cookie");
        System.out.print("<br/>Incoming Cookie: " + incomingCookie);
    }
}
