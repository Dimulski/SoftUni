import enums.StatusCode;
import http.HttpRequest;
import http.HttpResponse;
import http.Request;
import http.Response;
import router.Router;
import state.Session;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;

import static utils.WebConstants.RESOURCES_LOCATION;

public class RequestHandler {

    private Session session;
    private HttpRequest httpRequest;
    private HttpResponse httpResponse;

    public RequestHandler(Session session) {
        this.session = session;
    }

    public byte[] handleRequest(String requestContent) {
        this.httpRequest = new Request(requestContent);
        this.httpResponse = new Response();
        this.httpResponse.setProtocol(this.httpRequest.getProtocol());

        Router router = new Router(this.httpRequest, this.httpResponse, this.session);
        router.execute();

        return this.httpResponse.getBytes();
    }

    private byte[] getResources(String requestUrl) {
        byte[] resourceData = null;
        try {
            resourceData = Files.readAllBytes(Paths.get(RESOURCES_LOCATION + requestUrl));
            this.httpResponse.setStatusCode(StatusCode.OK);

            return resourceData;

        } catch (NoSuchFileException e) {
            this.httpResponse.setStatusCode(StatusCode.BAD_REQUEST);
        } catch (AccessDeniedException e) {
            this.httpResponse.setStatusCode(StatusCode.UNAUTHORIZED);
        } catch (IOException e) {
            this.httpResponse.setStatusCode(StatusCode.INTERNAL_SERVER_ERROR);
        }

        return null;
    }

    private String getExtension(String url) {
        return url.substring(url.lastIndexOf(".") + 1, url.length());
    }
}
