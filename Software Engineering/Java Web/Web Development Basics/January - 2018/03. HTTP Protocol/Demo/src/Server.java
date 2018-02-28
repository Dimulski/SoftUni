import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private int port;

    private ServerSocket server;

    public Server(int port) {
        this.port = port;
    }

    public void run() throws IOException {
        this.server = new ServerSocket(this.port);

        System.out.println("Listening to port: " + this.port);

        while (true) {
            Socket clientSocket = this.server.accept();

            BufferedReader requestStream = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            // BufferedWriter responseStream

            String line = "";

            while ((line = requestStream.readLine()) != null && line.length() > 0) {
                System.out.println(line);
            }

            requestStream.close();
        }
    }
}
