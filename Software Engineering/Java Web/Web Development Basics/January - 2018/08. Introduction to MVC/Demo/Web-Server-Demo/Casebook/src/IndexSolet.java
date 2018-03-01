import org.softuni.broccolina.solet.BaseHttpSolet;
import org.softuni.broccolina.solet.HttpSoletRequest;
import org.softuni.broccolina.solet.HttpSoletResponse;
import org.softuni.broccolina.solet.WebSolet;
import org.softuni.javache.http.HttpStatus;
import org.softuni.javache.io.Writer;

@WebSolet(route = "/index")
public class IndexSolet extends BaseHttpSolet {
    @Override
    public void doGet(HttpSoletRequest request, HttpSoletResponse response) {
        response.setStatusCode(HttpStatus.OK);

        response.addHeader("Content-Type", "text/html");

        response.setContent(("<h1>Hi, you in index, bro</h1>").getBytes());
    }
}
