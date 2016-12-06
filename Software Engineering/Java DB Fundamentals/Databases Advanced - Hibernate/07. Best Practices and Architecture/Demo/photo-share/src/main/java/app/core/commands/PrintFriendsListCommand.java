package app.core.commands;

import app.justdoitbyneki.ImplementItByYourself;

public class PrintFriendsListCommand extends Command {

    protected PrintFriendsListCommand(String[] data) {
        super(data);
    }

    /**
     * PrintFriendsList <username>
     * prints all friends of user with given username
     */
    @Override
    public String execute() {
        throw new ImplementItByYourself();
    }
}
