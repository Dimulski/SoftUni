package app.core.commands;

import app.justdoitbyneki.ImplementItByYourself;

public class UploadProfilePictureCommand extends Command {

    protected UploadProfilePictureCommand(String[] data) {
        super(data);
    }

    /**
     * UploadProfilePicture <username> <pictureFilePath>
     */
    @Override
    public String execute() {
        throw new ImplementItByYourself();
    }
}
