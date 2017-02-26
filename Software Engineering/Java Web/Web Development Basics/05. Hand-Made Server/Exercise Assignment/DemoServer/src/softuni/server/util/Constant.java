package softuni.server.util;

public interface Constant {

    int SOCKET_TIMEOUT = 20_000;
    String BAD_REQUEST_MESSAGE = "HTTP/1.1 400 Bad Request\n\n";
    String FILE_NOT_FOUND_MESSAGE = "HTTP/1.1 404 Not Found\n\n";
    String INTERNAL_SERVER_ERROR = "HTTP/1.1 500 Internal Server Error\n\n";
    String INITIAL_APP_DIR = System.getProperty("user.dir") + "out/production/DemoServer/softuni/app/";

}
