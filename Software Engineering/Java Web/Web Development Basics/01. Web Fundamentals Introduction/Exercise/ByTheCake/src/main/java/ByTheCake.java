public class ByTheCake {

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
                        "        <title>By The Cake</title>\n" +
                        "        <meta name=\"description\" content=\"Buy the cake in By The Cake\"/>\n" +
                        "        <meta name=\"author\" content=\"George Dimulski\"/>\n" +
                        "        <meta name=\"keywords\" content=\"Cake, Buy\">\n" +
                        "    </head>\n" +
                        "    <body>\n" +
                        "        <h1>By The Cake</h1>\n" +
                        "        <h2>Enjoy our awesome cakes</h2>\n" +
                        "        <hr/>\n" +
                        "        <ul>\n" +
                        "            <li><a href=\"\">Home</a>\n" +
                        "                <ol>\n" +
                        "                    <li><a href=\"#cakes\"> Our Cakes</a></li>\n" +
                        "                    <li><a href=\"#stores\">Out Stores</a></li>\n" +
                        "                </ol>\n" +
                        "            </li>\n" +
                        "            <li><a href=\"add_cake.cgi\">Add Cake</a></li>\n" +
                        "            <li><a href=\"browse_cakes.cgi\">Browse Cakes</a></li>\n" +
                        "            <li><a href=\"#aboutus\">About Us</a></li>\n" +
                        "        </ul>\n" +
                        "        <h2>Home</h2>\n" +
                        "        <h3><a name=\"cakes\">Our Cakes</a></h3>\n" +
                        "        <p><span style=\"font-weight: bold; font-style: italic\">Cake</span> is a form of " +
                        "<span style=\"font-weight: bold; font-style: italic\">sweet dessert</span> that is typically" +
                        " baked. In its oldest forms, cakes were modifications of breads, but cakes now cover a wide " +
                        "range of preparations that can be simple or elaborate, and that share features with other " +
                        "desserts such as pastries, meringues, custards and pies.</p>\n" +
                        "        <img src=\"/images/cake.jpg\" alt=\"cake image\"/>\n" +
                        "        <h3><a name=\"stores\">Our Stores</a></h3>\n" +
                        "        <p>Our stores are located in 21 cities all over the world. Come and see what we have" +
                        " for you.</p>\n" +
                        "        <img src=\"/images/cakestore.jpg\" alt=\"cake store image\"/>\n" +
                        "        <h2><a name=\"aboutus\">About us</a></h2>\n" +
                        "        <dl>\n" +
                        "            <dt>ByTheCake EOOD</dt>\n" +
                        "            <dd>Name of the company</dd>\n" +
                        "            <dt>George Dimulski</dt>\n" +
                        "            <dd>Owner</dd>\n" +
                        "        </dl>\n" +
                        "        <pre style=\"background-color: #f94f80\">\n" +
                        "            City: HongKong              City: Salzburg\n" +
                        "            Address: ChoCoLad 18        Address: SchokoLeiden 73\n" +
                        "            Phone: +78952804429\t        Phone: +49241432990</pre>\n" +
                        "        <hr/>\n" +
                        "        <footer style=\"text-align: center\">\n" +
                        "            &copy;All Rights Reserved.\n" +
                        "        </footer>\n" +
                        "    </body>\n" +
                        "</html>";
        System.out.println(body);
    }
}
