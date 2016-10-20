package net.java.main.interfaces;

import net.java.main.impl.utilities.exceptions.GameException;

public interface CommandDispatcher {

    void setEngine(Engine engine);

    void seedCommands();

    void dispatchCommand(String[] args) throws GameException;

}
