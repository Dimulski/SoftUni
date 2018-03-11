package javache;

import javache.http.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.UUID;

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
            case "/":
                try {
                    byte[] fileContents = Files.readAllBytes(Paths.get(assetsFolder + "\\html\\index.html"));
                    return this.ok(fileContents);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            case "/users/register":

                String email = this.httpRequest.getBodyParameters().get("email");
                String password = this.httpRequest.getBodyParameters().get("password");
                String confirm = this.httpRequest.getBodyParameters().get("confirm");
                if (!password.equals(confirm)) {
                    this.badRequest("Passwords mismatch".getBytes());
                }

                try {
                    User existingUser = this.findUserData(email);
                    if (existingUser != null) {
                        this.badRequest("User already exists".getBytes());
                    }

                    try (BufferedWriter writer = new BufferedWriter(new FileWriter(
                            System.getProperty("user.dir")
                                    + "\\src\\resources\\db\\users.txt", true))) {
                        writer.write(UUID.randomUUID().toString() + "|" + email + "|" + password + System.lineSeparator());
                    }

                    this.httpResponse.addHeader("Location", "/html/login.html");
                    return this.redirect(new byte[0]);

                } catch (IOException e) {
                    e.printStackTrace();
                }

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

    private User findUserData(String email) throws IOException {
        String dbPath = System.getProperty("user.dir") + "\\src\\resources\\db\\users.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(dbPath))) {
            String line = reader.readLine();
            while (line != null) {
                String[] userData = line.split("\\|");
                if (userData[1].equals(email)) {
                    return new User(userData[0], userData[1], userData[2]);
                }
                line = reader.readLine();
            }
        }

        return null;
    }

    class User {
        private String id;
        private String name;
        private String password;

        public User(String id, String name, String password) {
            this.id = id;
            this.name = name;
            this.password = password;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }
}
