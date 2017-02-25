package softuni.server;

import softuni.server.exception.BadRequestException;
import softuni.server.http.HttpContext;
import softuni.server.http.HttpContextImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ConnectionHandler implements Runnable {

    private final Socket socket;
    private final BufferedReader bufferedReader;
    private final PrintWriter printWriter;

    public ConnectionHandler(Socket clientSocket) throws IOException {
        this.socket = clientSocket;
        this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        this.printWriter = new PrintWriter(socket.getOutputStream());
    }

    @Override
    public void run() {
        StringBuilder stringBuilder = new StringBuilder();

        try {
            while (this.bufferedReader.ready() || stringBuilder.length() == 0) {
                stringBuilder.append((char) this.bufferedReader.read());
            }

            try {
                HttpContext httpContext = new HttpContextImpl(stringBuilder.toString());
            } catch (BadRequestException e) {
                this.printWriter.write("HTTP/1.1 400 Bad Request");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
