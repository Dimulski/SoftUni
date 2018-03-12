package javache;

import javache.http.*;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.UUID;

public class RequestHandler {

    private HttpRequest httpRequest;
    private HttpResponse httpResponse;
    private HttpSession session;
    private static final String SERVER_SESSION_KEY = "JAVACHE_SESSION_ID";

    public RequestHandler(HttpSession session) {
        this.session = session;
    }

    public byte[] handleRequest(String requestContent) {
        this.httpRequest = new HttpRequestImpl(requestContent);
        this.httpResponse = new HttpResponseImpl();

        String url = this.httpRequest.getRequestUrl();
        String resourcesFolder = System.getProperty("user.dir")
                + "\\src\\resources\\";
        String assetsFolder = resourcesFolder + "assets";
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
                    User existingUser = this.findUserDataByEmail(email);
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
                String loginEmail = this.httpRequest.getBodyParameters().get("email");
                String loginPassword = this.httpRequest.getBodyParameters().get("password");

                try {
                    User user = this.findUserDataByEmail(loginEmail);
                    if (user == null) {
                        return this.badRequest(new byte[0]);
                    }

                    if (!user.getPassword().equals(loginPassword)) {
                        return this.badRequest(new byte[0]);
                    }

                    String sessionId = UUID.randomUUID().toString();

                    this.session.setSessionData(
                            sessionId,
                            new HashMap<String, Object>() {{
                                put("userId", user.getId());
                            }}
                    );

                    this.httpResponse.addCookie(SERVER_SESSION_KEY, sessionId);

                    this.httpResponse.addHeader("Location", "/users/profile");
                    return this.redirect(new byte[0]);

                } catch (IOException e) {
                    e.printStackTrace();
                }

            case "/users/profile":
                byte[] guestContents = null;
                try {
                    guestContents = Files.readAllBytes(Paths.get(
                            resourcesFolder + "pages\\profile\\guest.html"
                    ));
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (!this.httpRequest.getCookies().containsKey(SERVER_SESSION_KEY)) {
                    return this.ok(guestContents);
                } else {
                    String sessionId = this.httpRequest.getCookies().get(SERVER_SESSION_KEY);
                    String userId = (String) this.session.getSessionData(sessionId)
                            .get("userId");
                    try {
                        User user = this.findUserDataById(userId);
                        if (user == null) {
                            return this.unauthorized(guestContents);
                        }

                        String loggedContents = javache.io.Reader.readAllLines(
                                new FileInputStream(resourcesFolder + "pages\\profile\\logged.html")
                        );

                        String loggedResponse = String.format(
                                loggedContents,
                                user.getName(),
                                user.getPassword()
                        );

                        return this.ok(loggedResponse.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
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

    private byte[] unauthorized(byte[] content) {
        this.httpResponse.setStatusCode(HttpStatus.Unauthorized);
        this.httpResponse.setContent(content);
        return this.httpResponse.getBytes();
    }

    private User find(String search, int index) throws IOException {
        String dbPath = System.getProperty("user.dir") + "\\src\\resources\\db\\users.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(dbPath))) {
            String line = reader.readLine();
            while (line != null) {
                String[] userData = line.split("\\|");
                if (userData[index].equals(search)) {
                    return new User(userData[0], userData[1], userData[2]);
                }
                line = reader.readLine();
            }
        }

        return null;
    }

    private User findUserDataById(String id) throws IOException {
        return this.find(id, 0);
    }

    private User findUserDataByEmail(String email) throws IOException {
        return this.find(email, 1);
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
