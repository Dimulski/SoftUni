public class SendEmail {

    public static void main(String[] args) {
        String contentType = "Content-Type: text/html\n";
        System.out.println(contentType);
        printHeader();
        printBody();
        printFooter();
    }

    public static void printBody() {
        String title = "<h2>Wel</h2><br/>";
        System.out.println(title);
    }



    public static void printHeader() {
        System.out.println("<html><body>");
    }

    public static void printFooter() {
        System.out.println("</body></html>");
    }
}
