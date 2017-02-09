package cakeWebSite.exercise10;

public class CakeWebSite {
    public static void main(String[] args) {
        setType();
        setHeader();
        setBody();
        setFooter();
    }

    private static void setType(){
        String type = "Content-Type: text/html\n";
        System.out.println(type);
    }

    private static void setHeader(){
        String header = "<html>" +
                "<head>" +
                "<title>By The Cake</title>" +
                "<meta charset=\"UTF8\"" +
                "<meta name=\"description\" content=\"Buy the cake in By The Cake\"" +
                "<meta name=\"keywords\" content=\"Cake,Buy\"" +
                "<meta name=\"author\" content=\"Name Family\"" +
                "</head>" +
                "<body>";
        System.out.println(header);
    }

    private static void setBody(){
        String body =
                "<h1>By the Cake</h1>" +
                        "<h2>Enjoy our awesome cakes</h2>" +
                        "<hr/>" +
                        "<br/>" +
                        "<ul>" +
                        "<li><a href=\"invoker.cgi\">Home</a>" +
                        "<ol>" +
                        "<li><a href=\"#cakes\">Our cakes</a></li>" +
                        "<li><a href=\"#stores\">Our stores</a></li>" +
                        "</ol>" +
                        "</li>" +
                        "<li><a href=\"add_cake.cgi\">Add cake</a></li>" +
                        "<li><a href=\"browse_cakes.cgi\">Browse cakes</a></li>" +
                        "<li><a href=\"#aboutus\">About us</a></li>" +
                        "</ul>" +
                        "<h2>Home</h2>" +
                        "<h3><a name=\"cakes\">Our cakes</a></h3>" +
                        "<p><b><i>Cake</i></b> is a form of <b><i>sweet dessert</i></b> that is typically baked. In its oldest forms, cakes were modifications of breads, but cakes now cover a wide range of preparations that can be simple or elaborate, and that share features with other desserts such as pastries, meringues, custards, and pies</p>" +
                        "<img src=\"http://leloupcake.com/index_files/cake-images-21.jpg\" alt=\"Cake Picture\" style=\"width:300;height:200;\">" +
                        "<h3><a name=\"stores\">Our stores</a></h3>" +
                        "<p>Our <b><i>stores</i></b> are located in 21 cities all over the world. Come and see what we have for you</p>" +
                        "<img src=\"https://i.ytimg.com/vi/aryWey6TQF0/maxresdefault.jpg\" alt=\"Store Picture\" style=\"width:300;height:200;\"" +
                        "<br/><h2><a name=\"aboutus\">About us</a></h2>" +
                        "<dl>" +
                        "<dt>ByTheCake EOOD</dt>" +
                        "<dd>Name of the company</dd>" +
                        "<dt>Teodor Dimitrov</dt>" +
                        "<dd>Owner</dd>" +
                        "</dl>" +
                        "<br/><pre style=\"background-color: #f94f80;\">" +
                        "City: HongKong\t\t City: Salzburg\n" +
                        "Address: ChoCoLad 18\t Address: SchokoLeiden 73\n" +
                        "Phone: +78952804429\t Phone: +49241432990\n" +
                        "</pre>";
        System.out.println(body);
    }

    private static void setFooter(){
        String footer = "<footer><hr/><p style=\"text-align: center\">" +
                "&#169;All Rights Reserved." +
                "</p></footer>" +
                "</body></html>";
        System.out.println(footer);
    }
}
