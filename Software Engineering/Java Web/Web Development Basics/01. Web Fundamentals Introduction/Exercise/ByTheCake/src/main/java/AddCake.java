public class AddCake {

    public static void main(String[] args) {
        setContentType();
        setHtml();
    }

    public static void setContentType() {
        String contentType = "Content-type: text/html \n";
        System.out.println(contentType);
    }

    public static void setHtml() {
        String html = "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "    <head>\n" +
                "        <meta charset=\"UTF-8\">\n" +
                "        <title>Title</title>\n" +
                "    </head>\n" +
                "    <body>\n" +
                "\n" +
                "    <form method=\"get\">\n" +
                "        <label>Cake</label>\n" +
                "        <input type=\"text\"/>\n" +
                "        <label>Price</label>\n" +
                "        <input type=\"text\"/>\n" +
                "        <input type=\"submit\", value=\"Submit\"/>\n" +
                "    </form>\n" +
                "    </body>\n" +
                "</html>";
        System.out.println(html);
    }

    public static boolean isGet() {
        boolean isGet = false;
        String method = System.getProperty("cgi.request_method");
        if (method.toLowerCase().equals("get")) {
            isGet = true;
        }

        return isGet;
    }
}
