package app.core.commands;

import app.justdoitbyneki.ImplementItByYourself;

public class ShareAlbumCommand extends Command {

    protected ShareAlbumCommand(String[] data) {
        super(data);
    }

    /**
     * ShareAlbum <albumId> <username> <permission>
     * For example:
     * ShareAlbum 4 dragon321 Owner
     * ShareAlbum 4 dragon11 Viewer
     */
    @Override
    public String execute() {
        throw new ImplementItByYourself();
    }
}
