package cakeWebSite.exercise2;

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
                        "</ul>";
        System.out.println(body);
    }

    private static void setFooter(){
        String footer = "</body></html>";
        System.out.println(footer);
    }
}
