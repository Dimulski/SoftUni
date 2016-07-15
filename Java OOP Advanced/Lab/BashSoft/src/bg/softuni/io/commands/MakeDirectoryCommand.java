package bg.softuni.io.commands;

import bg.softuni.contracts.AsynchDownloader;
import bg.softuni.contracts.ContentComparer;
import bg.softuni.contracts.Database;
import bg.softuni.contracts.DirectoryManager;
import bg.softuni.exceptions.InvalidInputException;

public class MakeDirectoryCommand extends Command {

    public MakeDirectoryCommand(String input,
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
        if (data.length != 2) {
            throw new InvalidInputException(this.getInput());
        }

        String folderName = data[1];
        this.getIoManager().createDirectoryInCurrentFolder(folderName);
    }
}
