package app.core.commands;

import app.annotations.Insert;
import app.domain.model.User;
import app.repository.UserRepository;

import java.util.Date;

public class RegisterUserCommand extends Command {

    @Insert
    private UserRepository users;

    protected RegisterUserCommand(String[] data) {
        super(data);
    }

    /**
     * RegisterUser <username> <password> <repeat-password> <email>
     */
    @Override
    public String execute() {
        String username = this.getData()[1];
        String password = this.getData()[2];
        String repeatPassword = this.getData()[3];
        String email = this.getData()[4];
        if (password.equals(repeatPassword)) {
            throw new UnsupportedOperationException("Passwords does not match");
        }
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setDeleted(false);
        user.setRegisteredOn(new Date());
        user.setLastTimeLoggedIn(new Date());

        users.save(user);
        return "User " + user.getUsername() + " was registered succesfully";
    }
}
