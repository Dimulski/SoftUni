package bg.softuni.io.commands;

import bg.softuni.contracts.*;
import bg.softuni.exceptions.InvalidInputException;

public class ChangeRelativePathCommand extends Command {

    public ChangeRelativePathCommand(String input,
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

        String relativePath = data[1];
        this.getIoManager().changeCurrentDirRelativePath(relativePath);
    }
}
