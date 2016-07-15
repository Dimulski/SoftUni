package bg.softuni.io.commands;

import bg.softuni.contracts.AsynchDownloader;
import bg.softuni.contracts.ContentComparer;
import bg.softuni.contracts.Database;
import bg.softuni.contracts.DirectoryManager;
import bg.softuni.exceptions.InvalidInputException;
import bg.softuni.io.OutputWriter;


public class DropDatabaseCommand extends Command {

    public DropDatabaseCommand(String input,
                               String[] data,
                               ContentComparer tester,
                               Database repository,
                               AsynchDownloader downloadManager,
                               DirectoryManager ioManager) {
        super(input, data, tester, repository, downloadManager, ioManager);
    }

    @Override
    public void execute() throws Exception {
        String[] data = this.getData();
        if (data.length != 1) {
            throw new InvalidInputException(this.getInput());
        }

        this.getRepository().unloadData();
        OutputWriter.writeMessageOnNewLine("Database dropped!");
    }
}
