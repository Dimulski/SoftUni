import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ConnectionHandler extends Thread {

    private Socket clientSocket;
    private RequestHandler handler;
    private InputStream clientInputStream;
    private OutputStream clientOutputStream;

    public ConnectionHandler(Socket clientSocket, RequestHandler requestHandler) {
        this.initConnection(clientSocket);
        this.handler = requestHandler;
    }

    @Override
    public void run() {
        try {
            String requestContent = io.Reader.readAllLines(this.clientInputStream);
            byte[] responseContent = this.handler.handleRequest(requestContent);
            io.Writer.writeResponseContent(responseContent, this.clientOutputStream);

            this.clientInputStream.close();
            this.clientOutputStream.close();
            this.clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        super.run();
    }

    private void initConnection(Socket clientSocket) {
        this.clientSocket = clientSocket;

        try {
            this.clientInputStream = this.clientSocket.getInputStream();
            this.clientOutputStream = this.clientSocket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
