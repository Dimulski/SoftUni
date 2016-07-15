package bg.softuni.io.commands;

import bg.softuni.contracts.*;
import bg.softuni.exceptions.InvalidInputException;

public abstract class Command implements Executable {
    private String input;
    private String[] data;
    private Database repository;
    private ContentComparer tester;
    private DirectoryManager ioManager;
    private AsynchDownloader downloadManager;

    protected Command(String input,
                      String[] data,
                      ContentComparer tester,
                      Database repository,
                      AsynchDownloader downloadManager,
                      DirectoryManager ioManager) {
        this.setInput(input);
        this.setData(data);
        this.tester = tester;
        this.repository = repository;
        this.downloadManager = downloadManager;
        this.ioManager = ioManager;
    }

    protected Database getRepository() {
        return repository;
    }

    protected ContentComparer getTester() {
        return tester;
    }

    protected DirectoryManager getIoManager() {
        return ioManager;
    }

    protected AsynchDownloader getDownloadManager() {
        return downloadManager;
    }

    protected String getInput() {
        return input;
    }

    private void setInput(String input) {
        if (input == null || input.equals("")) {
            throw new InvalidInputException(this.input);
        }
        this.input = input;
    }

    protected String[] getData() {
        return data;
    }

    private void setData(String[] data) {
        if (data == null || data.length < 1) {
            throw new InvalidInputException(this.input);
        }
        this.data = data;
    }

    public abstract void execute() throws Exception;

}
