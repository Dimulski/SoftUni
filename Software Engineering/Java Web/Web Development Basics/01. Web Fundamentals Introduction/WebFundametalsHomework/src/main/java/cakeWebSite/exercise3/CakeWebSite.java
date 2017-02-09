package cakeWebSite.exercise3;

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
        String header = "<html><body>";
        System.out.println(header);
    }

    private static void setBody(){
        String body =
                "<h1>By the Cake</h1>" +
                        "<h2>Enjoy our awesome cakes</h2>" +
                        "<hr/>" +
                        "<br/>" +
                        "<ul>" +
                        "<li>Home" +
                        "<ol>" +
                        "<li>Our cakes</li>" +
                        "<li>Our stores</li>" +
                        "</ol>" +
                        "</li>" +
                        "<li>Add cake</li>" +
                        "<li>Browse cakes</li>" +
                        "<li>About us</li>" +
                        "</ul>" +
                        "<h2>Home</h2>" +
                        "<h3>Our cakes</h3>" +
                        "<p>Cake is a form of sweet dessert that is typically baked. In its oldest forms, cakes were modifications of breads, but cakes now cover a wide range of preparations that can be simple or elaborate, and that share features with other desserts such as pastries, meringues, custards, and pies</p>" +
                        "<img src=\"http://leloupcake.com/index_files/cake-images-21.jpg\" alt=\"Cake Picture\" style=\"width:300;height:200;\">" +
                        "<h3>Our stores</h3>" +
                        "<p>Our stores are located in 21 cities all over the world. Come and see what we have for you</p>" +
                        "<img src=\"https://i.ytimg.com/vi/aryWey6TQF0/maxresdefault.jpg\" alt=\"Store Picture\" style=\"width:300;height:200;\">";
        System.out.println(body);
    }

    private static void setFooter(){
        String footer = "</body></html>";
        System.out.println(footer);
    }
}
