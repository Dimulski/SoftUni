package app.core.commands;

import app.domain.model.User;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class DeleteUserCommand extends Command {

    @Autowired
    private UserService userService;

    protected DeleteUserCommand(String[] data) {
        super(data);
    }

    /**
     * DeleteUser <username>
     * Delete User by username (only mark him as inactive)
     */
    @Override
    public String execute() {
        String username = this.getData()[1];
        User user = userService.findByUsername(username);
        if (user != null) {
            throw new UnsupportedOperationException("User with that username was not found");
        }

        user.setDeleted(true);
        return "User " + username + " was deleted from the database";
    }
}
