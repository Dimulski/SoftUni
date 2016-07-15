package bg.softuni;

import bg.softuni.contracts.*;
import bg.softuni.io.CommandInterpreter;
import bg.softuni.io.IOManager;
import bg.softuni.io.InputReader;
import bg.softuni.io.OutputWriter;
import bg.softuni.judge.Tester;
import bg.softuni.network.DownloadManager;
import bg.softuni.repository.RepositoryFilter;
import bg.softuni.repository.RepositorySorter;
import bg.softuni.repository.StudentsRepository;

public class Main {

    public static void main(String[] args) {
        ContentComparer tester = new Tester();
        AsynchDownloader downloadManager = new DownloadManager();
        DirectoryManager ioManager = new IOManager();
        DataSorter sorter = new RepositorySorter();
        DataFilter filter = new RepositoryFilter();
        Database repository = new StudentsRepository(filter, sorter);
        Interpreter currentInterpreter = new CommandInterpreter(
                tester, repository, downloadManager, ioManager);
        Reader reader = new InputReader(currentInterpreter);

        try {
            reader.readCommands();
        } catch (Exception e) {
            OutputWriter.displayException(e.getMessage());
        }
    }
}
