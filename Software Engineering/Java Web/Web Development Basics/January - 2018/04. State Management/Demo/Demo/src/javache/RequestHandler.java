package javache;

import javache.http.*;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class RequestHandler {

    private HttpRequest httpRequest;
    private HttpResponse httpResponse;

    public RequestHandler() { }

    public byte[] handleRequest(String requestContent) {
        this.httpRequest = new HttpRequestImpl(requestContent);
        this.httpResponse = new HttpResponseImpl();

        String url = this.httpRequest.getRequestUrl();
        String assetsFolder = System.getProperty("user.dir")
                + "\\src\\resources\\assets";
        switch (url) {
            case "/users/register":
                return this.ok("<p style='color:red'>I am register</p>".getBytes());
            case "/users/login":
                return this.ok("<p style='color:red'>I am login</p>".getBytes());
            case "/users/profile":
                return this.ok("<p style='color:red'>I am profile</p>".getBytes());
            default:
                String filePath = assetsFolder + url;
                File file = new File(filePath);
                if (!file.exists() || file.isDirectory()) {
                    return this.notFound(new byte[0]);
                }
                try {
                    if (!file.getCanonicalPath().startsWith(assetsFolder)) {
                        return this.badRequest(new byte[0]);
                    }
                    byte[] fileContents = Files.readAllBytes(Paths.get(filePath));

                    return this.ok(fileContents);
                } catch (IOException e) {
                    return this.notFound(new byte[0]);
                }
        }
    }

    private byte[] ok(byte[] content) {
        this.httpResponse.setStatusCode(HttpStatus.Ok);
        this.httpResponse.setContent(content);
        return this.httpResponse.getBytes();
    }

    private byte[] badRequest(byte[] content) {
        this.httpResponse.setStatusCode(HttpStatus.BadRequest);
        this.httpResponse.setContent(content);
        return this.httpResponse.getBytes();
    }

    private byte[] notFound(byte[] content) {
        this.httpResponse.setStatusCode(HttpStatus.NotFound);
        this.httpResponse.setContent(content);
        return this.httpResponse.getBytes();
    }

    private byte[] redirect(byte[] content) {
        this.httpResponse.setStatusCode(HttpStatus.SeeOther);
        this.httpResponse.setContent(content);
        return this.httpResponse.getBytes();
    }

    private byte[] internalServerError(byte[] content) {
        this.httpResponse.setStatusCode(HttpStatus.InternalServerError);
        this.httpResponse.setContent(content);
        return this.httpResponse.getBytes();
    }
}
