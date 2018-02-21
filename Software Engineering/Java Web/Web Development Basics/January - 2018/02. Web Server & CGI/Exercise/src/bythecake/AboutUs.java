package bythecake;

public class AboutUs {
    public static void main(String[] args) {
        String type = "Content-Type: text/html"
                + System.lineSeparator();

        String output =
                ""
                        + "<html"
                        + HtmlElements.HEADER_ELEMENT
                        + "<body>"
                        + "<a href=\"/cgi-bin/menu.cgi\">Back to Menu</a>"
                        + "<h2>About Us</h2>";

        output +=
                ""
                        + "<dl>"
                        + "<dt>ByTheCake EOOD</dt>"
                        + "<dd>Name of the company</dd>"
                        + "<dt>Runaljod</dt>"
                        + "<dd>Owner</dd>"
                        + "</dl>";

        output +=
                HtmlElements.FOOTER_ELEMENT
                        + "</body>"
                        + "</html>";

        System.out.println(type);
        System.out.println(output);
    }
}
