package softuni;

import softuni.server.Server;
import softuni.server.ServerImpl;

import java.io.IOException;
import java.net.ServerSocket;

public class Main {

    public static void main(String[] args) {

        try {
            ServerSocket serverSocket = new ServerSocket(8080);
            Server server = new ServerImpl(serverSocket);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
