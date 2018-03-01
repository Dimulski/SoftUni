package org.softuni.javache;

import org.softuni.javache.io.Reader;

import java.io.*;
import java.net.Socket;
import java.util.Map;
import java.util.Set;

public class ConnectionHandler extends Thread {
    private Socket clientSocket;

    private String cachedInpustStreamContent;

    private InputStream clientSocketInputStream;

    private OutputStream clientSocketOutputStream;

    private Set<String> requestHandlersPriority;

    private Map<String, RequestHandler> requestHandlers;

    public ConnectionHandler(Socket clientSocket, Set<String> requestHandlersPriority,
                             Map<String, RequestHandler> requestHandlers) {
        this.initializeConnection(clientSocket);
        this.requestHandlersPriority = requestHandlersPriority;
        this.requestHandlers = requestHandlers;
    }

    private InputStream getClientSocketInputStream() throws IOException {
        if(this.cachedInpustStreamContent == null) {
            this.cachedInpustStreamContent = Reader.readAllLines(this.clientSocketInputStream);
        }

        return new ByteArrayInputStream(this.cachedInpustStreamContent.getBytes());
    }

    private void initializeConnection(Socket clientSocket) {
        try {
            this.clientSocket = clientSocket;
            this.clientSocketInputStream = this.clientSocket.getInputStream();
            this.clientSocketOutputStream = this.clientSocket.getOutputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void processRequest() throws IOException {
        for (String requestHandlerName : this.requestHandlersPriority) {
            if(this.requestHandlers.containsKey(requestHandlerName)) {
                requestHandlers.get(requestHandlerName)
                        .handleRequest(this.getClientSocketInputStream(), this.clientSocketOutputStream);

                if (requestHandlers.get(requestHandlerName).hasIntercepted()) {
                    break;
                }
            }
        }
    }

    @Override
    public void run() {
        try {
            this.processRequest();
            this.clientSocketInputStream.close();
            this.clientSocketOutputStream.close();
            this.clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}






