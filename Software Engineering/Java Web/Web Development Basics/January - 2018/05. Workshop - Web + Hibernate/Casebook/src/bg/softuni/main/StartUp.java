package bg.softuni.main;

import bg.softuni.main.casebook.CasebookApplication;
import bg.softuni.main.database.models.User;
import bg.softuni.main.database.repositories.Repository;
import bg.softuni.main.database.repositories.UserRepository;
import bg.softuni.main.javache.Application;
import bg.softuni.main.javache.Server;
import bg.softuni.main.javache.WebConstants;

import java.io.IOException;

public class StartUp {
    public static void main(String[] args) {
//        Repository repository = new UserRepository();
//
//        repository.doAction("create", "Tosho", "4321");
//        User[] users = (User[]) repository.doAction("findAll");
//
//        for (User user : users) {
//            System.out.println(user.getUsername() + " " + user.getPassword());
//        }
//
//        repository.dismiss();
         start(args);
    }

    private static void start(String[] args) {
        int port = WebConstants.DEFAULT_SERVER_PORT;

        if (args.length > 1) {
            port = Integer.parseInt(args[1]);
        }

        Application application = new CasebookApplication();
        Server server = new Server(port, application);

        try {
            server.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
