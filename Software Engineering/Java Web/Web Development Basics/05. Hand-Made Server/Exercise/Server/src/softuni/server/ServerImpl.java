package softuni.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.concurrent.FutureTask;

public class ServerImpl implements Server {

    private boolean isRunning;
    private final ServerSocket serverSocket;

    public ServerImpl(ServerSocket serverSocket) {
        this.serverSocket = serverSocket;
    }

    @Override
    public void runServer() throws SocketException {
        System.out.println("Server started");

        this.isRunning = true;
        this.serverSocket.setSoTimeout(10000);
        this.acceptRequest();
    }

    private void acceptRequest() {
        while (isRunning) {
            try (Socket clientSocket = serverSocket.accept()){
                clientSocket.setSoTimeout(10000);
                ConnectionHandler connectionHandler = new ConnectionHandler(clientSocket);
                FutureTask<?> futureTask = new FutureTask<>(connectionHandler, null);
                futureTask.run();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
