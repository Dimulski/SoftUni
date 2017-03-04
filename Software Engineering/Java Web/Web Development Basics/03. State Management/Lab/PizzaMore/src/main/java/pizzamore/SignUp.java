package pizzamore;

import java.util.HashMap;
import java.util.Map;

public class SignUp {

    private static Map<String, String> parameters;

    private static Header header;

    private static UserRepository userRepository;

    static {
        parameters = new HashMap<>();
        header = new Header();
        userRepository = new UserRepository();
    }

    public static void main(String[] args) {
        readParameters();
        header.printHeader();
        readHtml();
    }

    public static void readParameters() {
        parameters = WebUtils.getParameters();
        String username = null;
        String password = null;
        for (String param : parameters.keySet()) {
            switch (param) {
                case "username":
                    username = parameters.get("username");
                    break;
                case "password":
                    password = parameters.get("password");
                    break;
                case "signup":
                    if (username.isEmpty() || password.isEmpty()) {
                        return;
                    }

                    User user = new User(username, password);
                    createUser(user);
                    header.addLocation("http://localhost:180/cgi-bin/signup.cgi");
                    break;
                case "main":
                    header.addLocation("http://localhost:180/cgi-bin/main.cgi");
                    break;
            }
        }
    }

    public static void createUser(User user) {
        userRepository.createUser(user);
    }
}
