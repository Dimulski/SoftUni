package app.core.commands;

import app.domain.model.User;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class MakeFriendsCommand extends Command {

    @Autowired
    private UserService userService;

    protected MakeFriendsCommand(String[] data) {
        super(data);
    }

    /**
     * bidirectional adding friends
     * MakeFriends <username1> <username2>
     */
    @Override
    public String execute() {
        String userNameOne = super.getData()[1];
        User userOne = this.userService.findByUsername(userNameOne);
        String userNameTwo = super.getData()[2];
        User userTwo = this.userService.findByUsername(userNameTwo);
        userOne.getFriends().add(userTwo);
        this.userService.create(userOne);
        return String.format("%s is friend with %s", userNameOne, userNameTwo);
    }
}
