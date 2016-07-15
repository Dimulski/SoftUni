package bg.softuni.io.commands;

import bg.softuni.contracts.AsynchDownloader;
import bg.softuni.contracts.ContentComparer;
import bg.softuni.contracts.Database;
import bg.softuni.contracts.DirectoryManager;
import bg.softuni.exceptions.InvalidInputException;
import bg.softuni.staticData.SessionData;

import java.awt.*;
import java.io.File;

public class OpenFileCommand extends Command {

    public OpenFileCommand(String input,
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

        String fileName = data[1];
        String filePath = SessionData.currentPath + "\\" + fileName;
        File file = new File(filePath);
        Desktop.getDesktop().open(file);
    }
}
