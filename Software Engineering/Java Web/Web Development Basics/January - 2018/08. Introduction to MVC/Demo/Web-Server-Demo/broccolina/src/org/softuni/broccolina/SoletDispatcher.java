package org.softuni.broccolina;

import org.softuni.broccolina.solet.*;
import org.softuni.broccolina.util.SoletLoader;
import org.softuni.javache.RequestHandler;
import org.softuni.javache.http.*;
import org.softuni.javache.io.Reader;
import org.softuni.javache.io.Writer;

import java.io.*;
import java.util.Map;

public class SoletDispatcher implements RequestHandler {

    private final String SERVER_ROOT_PATH;

    private boolean intercepted;

    private SoletLoader soletLoader;

    public SoletDispatcher(String serverRootPath) {
        this.SERVER_ROOT_PATH = serverRootPath;
        this.intercepted = false;
        this.soletLoader = new SoletLoader(SERVER_ROOT_PATH);
        this.soletLoader.loadSolets();
    }

    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream) {
        try {
            String requestContent = Reader.readAllLines(inputStream);

            HttpRequest request = new HttpRequestImpl(requestContent);
            HttpSoletResponse response = new HttpSoletResponseImpl(outputStream);

            for (Map.Entry<String, HttpSolet> soletEntry
                    : this.soletLoader.getSolets().entrySet()) {

                String soletRoute = "/" + soletEntry.getKey();

                if (soletRoute.equals(request.getRequestUrl())) {

                    if(request.getMethod().equals("GET")) {
                        soletEntry.getValue().doGet(
                                new HttpSoletRequestImpl(requestContent, null),
                                response);
                    } else if(request.getMethod().equals("POST")) {
                        soletEntry.getValue().doPost(
                                new HttpSoletRequestImpl(requestContent, null),
                                response);
                    } else if(request.getMethod().equals("PUT")) {
                        soletEntry.getValue().doPut(
                                new HttpSoletRequestImpl(requestContent, null),
                                response);
                    } else if(request.getMethod().equals("DELETE")) {
                        soletEntry.getValue().doDelete(
                                new HttpSoletRequestImpl(requestContent, null),
                                response);
                    }

                    Writer.writeBytes(response.getBytes(), outputStream);
                    this.intercepted = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            this.intercepted = false;
        }
    }

    @Override
    public boolean hasIntercepted() {
        return this.intercepted;
    }
}
