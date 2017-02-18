package bootstrap;

public class BootstrapDemo {

    public static void main(String[] args) {

        System.out.print("Content-Type: text/html\n\n");
        System.out.println("<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "    <head>\n" +
                "        <meta charset=\"UTF-8\">\n" +
                "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
                "        <title>Title</title>\n" +
                "        <link rel='stylesheet' href='/bootstrap/css/bootstrap.min.css'/>\n" +
                "        <link rel=\"stylesheet\" type=\"text/css\" href=\"/css/index.css\"/>\n" +
                "    </head>\n" +
                "    <body>\n" +
                "        <div class=\"container-fluid\">\n" +
                "            <div class=\"row\">\n" +
                "                <div class=\"col-lg-3 col-sm-6 col-xs-12\">\n" +
                "                    R1 Article 1\n" +
                "                </div>\n" +
                "                <div class=\"col-lg-3 col-sm-6 col-xs-12\">\n" +
                "                    R1 Article 2\n" +
                "                </div>\n" +
                "                <div class=\"col-lg-3 col-sm-6 col-xs-12\">\n" +
                "                    R1 Article 3\n" +
                "                </div>\n" +
                "                <div class=\"col-lg-3 col-sm-6 col-xs-12\">\n" +
                "                    R1 Article 4\n" +
                "                </div>\n" +
                "            </div>\n" +
                "\n" +
                "            <table class=\"table table-hover\">\n" +
                "                <tr>\n" +
                "                    <th>Major</th>\n" +
                "                    <th>Grade</th>\n" +
                "                    <th>Exam Date</th>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td>Java</td>\n" +
                "                    <td>6</td>\n" +
                "                    <td>12/12/2015</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <td>Perl</td>\n" +
                "                    <td>5</td>\n" +
                "                    <td>16/12/1997</td>\n" +
                "                </tr>\n" +
                "            </table>\n" +
                "\n" +
                "            <form class=\"form-horizontal\">\n" +
                "                <div class=\"form-group\">\n" +
                "                    <label class=\"control-label col-sm-2\">Username: </label>\n" +
                "                    <div class=\"col-sm-4\">\n" +
                "                        <input class=\"form-control\" type=\"email\">\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "                <div class=\"form-group\">\n" +
                "                    <label class=\"control-label col-sm-2\">Password: </label>\n" +
                "                    <div class=\"col-sm-4\">\n" +
                "                        <input class=\"form-control\" type=\"password\">\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "                <div class=\"form-group\">\n" +
                "                    <div class=\"col-sm-2 col-sm-offset-2\">\n" +
                "                        <input class=\"btn btn-success\" type=\"submit\" value=\"Log In\">\n" +
                "                    </div>\n" +
                "                </div>\n" +
                "                <div class=\"jumbotron\">\n" +
                "                    <h1>Bootstrap</h1>\n" +
                "                    <p>Mobile first framework</p>\n" +
                "                </div>\n" +
                "\n" +
                "            </form>\n" +
                "        </div>\n" +
                "\n" +
                "<div class=\"alert alert-success alert-dismissable\">\n" +
                "  <a class=\"close\" data-dismiss=\"alert\" aria-label=\"close\">x</a>\n" +
                "  <strong>Success!</strong> \u000B  This alert box could indicate a successful or positive action.\n" +
                "</div>\n" +
                "        <script src=\"/jquery/jquery.js\"></script>\n" +
                "        <script src=\"/bootstrap/js/bootstrap.min.js\"></script>\n" +
                "    </body>\n" +
                "</html>");
    }
}
