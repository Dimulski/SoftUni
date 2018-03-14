package javache;

import javache.http.*;
import javache.repositories.UserRepository;
import javache.repositories.UserRepositoryImpl;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

public class RequestHandler {
    private HttpRequest httpRequest;
    private HttpResponse httpResponse;
    private HttpSession session;
    private UserRepository userRepository;
    private static final String SERVER_SESSION_KEY = "JAVACHE_SESSION_ID";

    public RequestHandler(HttpSession session) {
        this.session = session;
    }

    public byte[] handleRequest(String requestContent) {
        this.httpRequest = new HttpRequestImpl(requestContent);
        this.httpResponse = new HttpResponseImpl();
        this.userRepository = new UserRepositoryImpl();

        String url = this.httpRequest.getRequestUrl();
        String resourcesFolder = System.getProperty("user.dir") + "\\src\\resources\\";
        String assetsFolder = resourcesFolder + "assets";

        switch (url) {
            case "/":
                try {
                    byte[] fileContents = Files.readAllBytes(Paths.get(assetsFolder + "\\html\\index.html"));
                    return this.ok(fileContents);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            case "/users/register": {
                String email = this.httpRequest.getBodyParameters().get("email");
                String password = this.httpRequest.getBodyParameters().get("password");
                String confirmPassword = this.httpRequest.getBodyParameters().get("confirmPassword");

                if (!password.equals(confirmPassword)) {
                    this.badRequest("Passwords mismatch".getBytes());
                }

                User existingUser = (User) this.userRepository.findByEmail(email);
                if (existingUser != null) {
                    this.badRequest("User already exists".getBytes());
                }

                this.userRepository.add(new User(UUID.randomUUID().toString(), email, password));

                this.httpResponse.addHeader("Location", "/html/login.html");
                return this.redirect(new byte[0]);
            }
            case "/users/login": {
                String loginEmail = this.httpRequest.getBodyParameters().get("email");
                String loginPassword = this.httpRequest.getBodyParameters().get("password");

                User user = (User) this.userRepository.findByEmail(loginEmail);
                if (user == null) {
                    return this.badRequest(new byte[0]);
                }

                if (!user.getPassword().equals(loginPassword)) {
                    return this.badRequest(new byte[0]);
                }

                String sessionId = UUID.randomUUID().toString();
                this.session.setSessionData(
                        sessionId,
                        new HashMap<>() {{
                            put("userId", user.getId());
                        }}
                );

                this.httpResponse.addCookie(SERVER_SESSION_KEY, sessionId + "; Path=/");

                this.httpResponse.addHeader("Location", "/users/profile");
                return this.redirect(new byte[0]);
            }

            case "/users/profile": {
                byte[] guestContents = null;
                try {
                    guestContents = Files.readAllBytes(Paths.get(
                            resourcesFolder + "pages\\profile\\guest.html"));
                } catch (IOException e) {
                    e.printStackTrace();
                }

                if (!this.httpRequest.getCookies().containsKey(SERVER_SESSION_KEY)) {
                    return this.ok(guestContents);
                } else {
                    String sessionId = this.httpRequest.getCookies().get(SERVER_SESSION_KEY);
                    String userId = (String) this.session.getSessionData(sessionId).get("userId");
                    try {
                        User user = (User) this.userRepository.getById(userId);
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
            }

            case "/home": {
                if (!this.httpRequest.getCookies().containsKey(SERVER_SESSION_KEY)) {
                    return this.redirect(new byte[0]); // redirect here
                } else {
                    String sessionId = this.httpRequest.getCookies().get(SERVER_SESSION_KEY);
                    String userId = (String) this.session.getSessionData(sessionId).get("userId");
                    try {
                        User user = (User) this.userRepository.getById(userId);
                        if (user == null) {
                            return this.unauthorized(new byte[0]); // redirect or unauthorized
                        }

                        String homeContents = javache.io.Reader.readAllLines(
                                new FileInputStream(resourcesFolder + "pages\\home.html")
                        );

                        StringBuilder users = new StringBuilder();
                        this.getUsersNames().stream().filter(u -> !u.equals(user.getName()))
                                .forEach(u -> users.append(u + "<br/>"));
                        System.out.println(users);
                        String loggedResponse = String.format(
                                homeContents,
                                users
                        );

                        return this.ok(loggedResponse.getBytes());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

            default: {
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
                    e.printStackTrace();
                }
            }
        }
        return new byte[0];
    }

    private List<String> getUsersNames() throws IOException { // use UserRepository
        String dbPath = System.getProperty("user.dir") + "\\src\\db\\users.txt";
        List<String> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(dbPath))) {

            String line = reader.readLine();
            while (line != null) {
                String[] userData = line.split("\\|");
                users.add(userData[1]);
                line = reader.readLine();
            }
        }

        return users;
    }

    private User find(String search, int index) throws IOException {
        String dbPath = System.getProperty("user.dir") + "\\src\\db\\users.txt";

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

    private byte[] ok(byte[] content) {
        this.httpResponse.setStatusCode(HttpStatus.OK);
        this.httpResponse.setContent(content);

        return this.httpResponse.getBytes();
    }

    private byte[] notFound(byte[] content) {
        this.httpResponse.setStatusCode(HttpStatus.NOT_FOUND);
        this.httpResponse.setContent(content);

        return this.httpResponse.getBytes();
    }

    private byte[] badRequest(byte[] content) {
        this.httpResponse.setStatusCode(HttpStatus.BAD_REQUEST);
        this.httpResponse.setContent(content);

        return this.httpResponse.getBytes();
    }

    private byte[] redirect(byte[] content) {
        this.httpResponse.setStatusCode(HttpStatus.SEE_OTHER);
        this.httpResponse.setContent(content);

        return this.httpResponse.getBytes();
    }

    private byte[] internalServerError(byte[] content) {
        this.httpResponse.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR);
        this.httpResponse.setContent(content);

        return this.httpResponse.getBytes();
    }

    private byte[] unauthorized(byte[] content) {
        this.httpResponse.setStatusCode(HttpStatus.UNAUTHORIZED);
        this.httpResponse.setContent(content);

        return this.httpResponse.getBytes();
    }
}
