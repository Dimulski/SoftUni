package bg.softuni.io.commands;

import bg.softuni.contracts.AsynchDownloader;
import bg.softuni.contracts.ContentComparer;
import bg.softuni.contracts.Database;
import bg.softuni.contracts.DirectoryManager;
import bg.softuni.exceptions.InvalidInputException;

public class ShowCourseCommand extends Command {

    public ShowCourseCommand(String input,
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
        if (data.length != 2 && data.length != 3) {
            throw new InvalidInputException(this.getInput());
        }

        if (data.length == 2) {
            String courseName = data[1];
            this.getRepository().getStudentsByCourse(courseName);
            return;
        }

        String courseName = data[1];
        String userName = data[2];
        this.getRepository().getStudentMarkInCourse(courseName, userName);

    }
}
