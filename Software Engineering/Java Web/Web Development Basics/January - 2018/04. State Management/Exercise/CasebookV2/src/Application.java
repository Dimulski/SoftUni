import java.io.IOException;

import static utils.WebConstants.PORT;

public class Application {

    public static void main(String[] args) {
        Server server = new Server(PORT);
        try {
            server.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
