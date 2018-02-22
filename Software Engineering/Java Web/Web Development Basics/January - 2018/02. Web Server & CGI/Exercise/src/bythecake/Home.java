package bythecake;

public class Home {
    public static void main(String[] args) {
        String type = "Content-Type: text/html"
                + System.lineSeparator();

        String output =
                ""
                        + "<html"
                        + HtmlElements.HEADER_ELEMENT
                        + "<body>"
                        + "<a href=\"/cgi-bin/menu.cgi\">Back to Menu</a>"
                        + "<h2>Home</h2>";

        // Our cake section
        output +=
                ""
                        + "<section>"
                        + "<h3 id=\"cakes\">Our Cakes</h3>"
                        + "<p><strong>Cake<em></em></strong> is a form of <strong><em>sweet dessert</em></strong> that is typically baked. In its oldest forms, cakes were "
                        + "modifications of breads, but cakes now cover a wide range of preparations that can be simple"
                        + " or elaborate, and that share features with other desserts such as pastries, meringues,"
                        + " custards, and pies</p>"
                        + "<img src=\"/cake.jpg\" alt=\"Cake Image\" width=\"500\" height=\"500\">"
                        + "</section>";

        // Our cake stores
        output +=
                ""
                        + "<section>"
                        + "<h3 id=\"stores\">Our Stores</h3>"
                        + "<p>Our stores are located in 21 cities all over the world. Come and see what we have for you.</p>"
                        + "<img src=\"/store.jpg\" alt=\"Cake Store Image\" width=\"500\" height=\"500\">"
                        + "</section>";

        output +=
                HtmlElements.FOOTER_ELEMENT
                        + "</body>"
                        + "</html>";

        System.out.println(type);
        System.out.println(output);
    }
}
