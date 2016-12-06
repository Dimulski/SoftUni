package app.core.commands;

public class ExitCommand extends Command {

    protected ExitCommand(String[] data) {
        super(data);
    }

    /**
     *
     */
    @Override
    public String execute() {
        System.exit(0);
        return null;
    }
}
