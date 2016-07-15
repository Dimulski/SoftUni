package bg.softuni.io.commands;

import bg.softuni.contracts.AsynchDownloader;
import bg.softuni.contracts.ContentComparer;
import bg.softuni.contracts.Database;
import bg.softuni.contracts.DirectoryManager;
import bg.softuni.exceptions.InvalidInputException;

public class TraverseFoldersCommand extends Command {

    public TraverseFoldersCommand(String input,
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
        if (data.length != 1 && data.length != 2) {
            throw new InvalidInputException(this.getInput());
        }

        if (data.length == 1) {
            this.getIoManager().traverseDirectory(0);
            return;
        }

        this.getIoManager().traverseDirectory(Integer.valueOf(data[1]));
    }
}
