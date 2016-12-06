package app.core.commands;

import app.justdoitbyneki.ImplementItByYourself;

public class ModifyUserCommand extends Command {

    protected ModifyUserCommand(String[] data) {
        super(data);
    }

    /**
     * ModifyUser <username> <property> <new value>
     * For example:
     * ModifyUser <username> Password <NewPassword>
     * ModifyUser <username> Email <NewEmail>
     * ModifyUser <username> FirstName <NewFirstName>
     * ModifyUser <username> LastName <newLastName>
     * ModifyUser <username> BornTown <newBornTownName>
     * ModifyUser <username> CurrentTown <newCurrentTownName>
     * !!! Cannot change username
     */
    @Override
    public String execute() {
        throw new ImplementItByYourself();
    }
}
