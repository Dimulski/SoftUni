import state.Session;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.UUID;
import java.util.concurrent.FutureTask;

public class Server {

    private static final int TIME_OUT_MILLISECONDS = 5000;

    private int port;
    private int timeOuts;
    private ServerSocket serverSocket;

    public Server(int port) {
        this.port = port;
        this.timeOuts = 0;
    }

    public void run() throws IOException {
        this.serverSocket = new ServerSocket(this.port);

        Session session = new Session();
        session.setId(UUID.randomUUID().toString());

        while (true) {
            System.out.println("Listening on: " + this.port);
            try (Socket clientSocket = serverSocket.accept()) {
                clientSocket.setSoTimeout(TIME_OUT_MILLISECONDS);
                ConnectionHandler connectionHandler = new ConnectionHandler(clientSocket, new RequestHandler(session));
                FutureTask<?> task = new FutureTask<>(connectionHandler, null);
                task.run();
            } catch (SocketTimeoutException e) {
                System.out.println("--- Session ended ---");
                return;
            }
        }
    }
}
