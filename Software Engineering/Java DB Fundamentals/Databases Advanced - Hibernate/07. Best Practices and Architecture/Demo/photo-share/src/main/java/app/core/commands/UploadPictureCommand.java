package app.core.commands;

import app.justdoitbyneki.ImplementItByYourself;

public class UploadPictureCommand extends Command {


    protected UploadPictureCommand(String[] data) {
        super(data);
    }

    /**
     * UploadPicture <albumName> <pictureTitle> <pictureFilePath>
     */
    @Override
    public String execute() {
        throw new ImplementItByYourself();
    }
}
