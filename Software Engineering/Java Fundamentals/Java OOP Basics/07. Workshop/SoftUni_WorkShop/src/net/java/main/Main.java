package net.java.main;

import net.java.main.impl.utilities.core.BattlegroundImpl;
import net.java.main.impl.utilities.core.EngineImpl;
import net.java.main.impl.utilities.helpers.CommandDispatcherImpl;
import net.java.main.impl.utilities.helpers.InputReaderImpl;
import net.java.main.impl.utilities.helpers.OutputWriterImpl;
import net.java.main.interfaces.*;

public class Main {

    private static final int ROWS = 5;
    private static final int COLS = 5;

    public static void main(String[] args) {
        InputReader reader = new InputReaderImpl();
        OutputWriter writer = new OutputWriterImpl();
        Battleground battleground = new BattlegroundImpl(ROWS, COLS);
        CommandDispatcher commandDispatcher = new CommandDispatcherImpl();

        Engine gameEngine = new EngineImpl(reader, writer, battleground, commandDispatcher);
        gameEngine.start();
    }
}
