package net.java.main.impl.utilities.core;

import net.java.main.impl.utilities.exceptions.GameException;
import net.java.main.impl.utilities.models.units.Unit;
import net.java.main.interfaces.*;

import java.util.ArrayList;
import java.util.List;

public class EngineImpl implements Engine {

    private boolean isStarted;
    private List<Unit> units;
    private OutputWriter outputWriter;
    private InputReader inputReader;
    private Battleground battleground;
    private CommandDispatcher commandDispatcher;

    public EngineImpl(
            InputReader inputReader,
            OutputWriter outputWriter,
            Battleground battleground,
            CommandDispatcher commandDispatcher) {
        this.outputWriter = outputWriter;
        this.inputReader = inputReader;
        this.battleground = battleground;
        this.commandDispatcher = commandDispatcher;

        this.commandDispatcher.setEngine(this);

        this.units = new ArrayList<>();
    }

    @Override
    public List<Unit> getUnits() {
        return this.units;
    }

    @Override
    public OutputWriter getOutputWriter() {
        return this.outputWriter;
    }

    @Override
    public Battleground getBattleground() {
        return this.battleground;
    }

    @Override
    public void start() {
        this.isStarted = true;
        this.commandDispatcher.seedCommands();

        while (this.isStarted) {
            String userInput = this.inputReader.readLine();
            String[] args = userInput.split(" ");

            try {
                this.commandDispatcher.dispatchCommand(args);
            } catch (GameException e) {
                this.getOutputWriter().writeLine(e.getMessage());
            }
        }
    }

    @Override
    public void stop() {
        this.isStarted = false;
    }

    @Override
    public void insetUnit(Unit unit) {
        this.units.add(unit);
    }

    @Override
    public void removeUnit(Unit unit) {
        this.units.remove(unit);
    }
}
