package net.java.main.impl.utilities.helpers;

import net.java.main.impl.utilities.commands.*;
import net.java.main.impl.utilities.exceptions.GameException;
import net.java.main.interfaces.Command;
import net.java.main.interfaces.CommandDispatcher;
import net.java.main.interfaces.Engine;

import java.util.HashMap;
import java.util.Map;

public class CommandDispatcherImpl implements CommandDispatcher {
    private Engine engine;
    Map<String, Command> commands;

    public CommandDispatcherImpl() {
        this.commands = new HashMap<>();
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void seedCommands() {
        this.commands.put("spawn", new SpawnCommand(this.engine));
        this.commands.put("status", new StatusCommand(this.engine));
        this.commands.put("fight", new FightCommand(this.engine));
        this.commands.put("move", new MoveCommand(this.engine));
        this.commands.put("game-over", new GameOverCommand(this.engine));
    }

    @Override
    public void dispatchCommand(String[] args) throws GameException {
        String command = args[0];

        if (!this.commands.containsKey(command)) {
            throw new GameException("Unknown command!");
        }

        this.commands.get(command).execute(args);
    }
}
