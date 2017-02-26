import softuni.server.Server;
import softuni.server.ServerImpl;
import softuni.server.provider.ClassProvider;
import softuni.server.provider.ClassProviderImpl;

import java.io.IOException;
import java.net.ServerSocket;

public class Main {

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            ClassProvider classProvider = new ClassProviderImpl();
            Server server = new ServerImpl(serverSocket, classProvider);

            server.runServer();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }


    }
}
