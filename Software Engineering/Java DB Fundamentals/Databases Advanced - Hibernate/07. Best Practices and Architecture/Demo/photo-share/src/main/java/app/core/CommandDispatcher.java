package app.core;

public interface CommandDispatcher {
    Executable dispatchCommand(String commandName, String[] commandParameters);
}
