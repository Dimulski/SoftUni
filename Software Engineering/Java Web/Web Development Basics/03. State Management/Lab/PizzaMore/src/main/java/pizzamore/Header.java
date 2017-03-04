package pizzamore;

import java.util.ArrayList;
import java.util.List;

public class Header {

    private String type;

    private String location;

    private List<Cookie> cookies;

    public Header() {
        this.type = "Content-type: text/html"; // ; IS REMOVED
        this.cookies = new ArrayList<Cookie>();
    }

    public void addLocation(String location) {
        this.location = location;
    }

    public void addCookie(Cookie cookie) {
        this.cookies.add(cookie);
    }

    public void printHeader() {
        System.out.println(this.type);

        if (!this.cookies.isEmpty()) {
            String cookies = "";
            for (Cookie cookie : this.cookies) {
                cookies += cookie.getCookieValue();
            }

            System.out.println("Set-Cookie: " + cookies);
        }

        if (this.location != null) {
            System.out.println("Location: " + this.location);
        }

        //End of header
        System.out.println();
    }
}
