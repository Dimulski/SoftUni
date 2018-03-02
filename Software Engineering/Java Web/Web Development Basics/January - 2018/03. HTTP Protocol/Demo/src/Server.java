import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Server {
    private int port;

    private ServerSocket server;

    private HashMap<String, String> supportedContentTypes;

    public Server(int port) {
        this.port = port;
        this.supportedContentTypes = new HashMap<>();
        this.seedSupportedContentTypes();
    }

    private void seedSupportedContentTypes() {
        this.supportedContentTypes.put("png", "image/png");
        this.supportedContentTypes.put("jpg", "image/jpeg");
        this.supportedContentTypes.put("jpeg", "image/jpeg");
        this.supportedContentTypes.put("html", "text/html");
        this.supportedContentTypes.put("html", "text/html");
    }

    public void run() throws IOException {
        this.server = new ServerSocket(this.port);

        System.out.println("Listening to port: " + this.port);

        while (true) {
            Socket clientSocket = this.server.accept();

            BufferedReader requestStream = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

            DataOutputStream responseStream = new DataOutputStream(clientSocket.getOutputStream());

            StringBuilder requestContent = new StringBuilder();

            String line = "";

            while ((line = requestStream.readLine()) != null && line.length() > 0) {
                requestContent.append(line).append(" ");
            }

            byte[] requestResult = this.handleRequest(requestContent.toString());

            byte[] responseContent = this.constructResponse(requestContent.toString(), requestResult);

            responseStream.close();
            requestStream.close();
        }
    }

    private byte[] handleRequest(String requestContent) {
        String requestMethod = this.extractRequestMethod(requestContent);
        String requestResource = this.extractRequestResource(requestContent);

        if (requestMethod.equals("GET")) {
            byte[] fileData = this.get(requestResource);
            return fileData;
        }

        return null;
    }

    private byte[] constructResponse(String requestContent, byte[] requestResult) {
        String resourceName = this.extractRequestResource(requestContent);
        String resourceExtension = resourceName.substring(resourceName.lastIndexOf(".") + 1);

        StringBuilder responseHeaders = new StringBuilder()
                .append("HTTP/1.1 200 OK").append(System.lineSeparator())
                .append("Server: ").append("Javache/-1.0.0").append(System.lineSeparator())
                .append("Date: ").append(new Date()).append(System.lineSeparator())
                .append("Content-Disposition: ").append("inline").append(System.lineSeparator())
                .append("Content-Length: ").append(requestResult.length).append(System.lineSeparator())
                .append("Content-Type: ").append(this.getContentType(resourceExtension)).append(System.lineSeparator())
                .append(System.lineSeparator());

        byte[] headersAsBytes = responseHeaders.toString().getBytes();

        byte[] fullResponseByteData = new byte[headersAsBytes.length + requestResult.length];

        for (int i = 0; i < headersAsBytes.length; i++) {
            fullResponseByteData[i] = headersAsBytes[i];
        }

        for (int i = 0; i <requestResult.length; i++) {
            fullResponseByteData[i + headersAsBytes.length] = requestResult[i];
        }

        return fullResponseByteData;
    }

    private byte[] get(String requestResource) {
        byte[] fileByteData = null;

        try {
            fileByteData = Files.readAllBytes(Paths.get("C:\\SoftUni\\Software Engineering\\Java Web\\Web Development Basics\\January - 2018\\03. HTTP Protocol\\Demo\\src\\resources\\" + requestResource));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return fileByteData;
    }

    private String getContentType(String resourceExtension) {
        if (this.supportedContentTypes.containsKey(resourceExtension)) {
            return this.supportedContentTypes.get(resourceExtension);
        }

        return "text/plain";
    }

    private String extractRequestMethod(String requestContent) {
        return requestContent.split("\\s")[0];
    }

    private String extractRequestResource(String requestContent) {
        return requestContent.split("\\s")[1];
    }
}
