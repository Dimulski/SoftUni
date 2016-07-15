package bg.softuni.io.commands;

import bg.softuni.contracts.*;
import bg.softuni.exceptions.InvalidInputException;

public class CompareFilesCommand extends Command {

    public CompareFilesCommand(String input,
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
        if (data.length != 3) {
            throw new InvalidInputException(this.getInput());
        }

        String firstPath = data[1];
        String secondPath = data[2];
        this.getTester().compareContent(firstPath, secondPath);
    }
}
