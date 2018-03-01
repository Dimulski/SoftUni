import org.softuni.broccolina.solet.BaseHttpSolet;
import org.softuni.broccolina.solet.HttpSoletRequest;
import org.softuni.broccolina.solet.HttpSoletResponse;
import org.softuni.broccolina.solet.WebSolet;
import org.softuni.javache.http.HttpStatus;

@WebSolet(route = "/test")
public class TestSolet extends BaseHttpSolet {
    @Override
    public void doPost(HttpSoletRequest request, HttpSoletResponse response) {
        response.setStatusCode(HttpStatus.OK);

        response.addHeader("Content-Type", "text/html");

        response.setContent(("<h1>Hi MATE FROM POST</h1>").getBytes());
    }
}
