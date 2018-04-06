package bg.softuni.main;

import bg.softuni.main.database.repositories.Repository;
import bg.softuni.main.database.repositories.UserRepository;
import bg.softuni.main.javache.Application;
import bg.softuni.main.javache.Server;
import bg.softuni.main.javache.WebConstants;

import java.io.IOException;

public class StartUp {
    public static void main(String[] args) {
        Repository repository = new UserRepository();

        boolean result = (boolean) repository.doAction("create", "Pesho", "123");

        System.out.println(result);
//         start(args);
    }

    private static void start(String[] args) {
        int port = WebConstants.DEFAULT_SERVER_PORT;

        if (args.length > 1) {
            port = Integer.parseInt(args[1]);
        }

        Application application = null;
        Server server = new Server(port, application);

        try {
            server.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
