package app.core.commands;

import app.domain.model.Album;
import app.domain.model.Tag;
import app.service.AlbumService;
import app.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;

public class AddTagToCommand extends Command {

    @Autowired
    private TagService tagService;

    @Autowired
    private AlbumService albumService;

    protected AddTagToCommand(String[] data) {
        super(data);
    }

    /**
     * AddTagTo <albumName> <tag>
     */
    @Override
    public String execute() {
        String albumName = super.getData()[1];
        String tagName = super.getData()[2];
        Tag tag = this.tagService.findByName(tagName);
        Album album = this.albumService.findByName(albumName);
        album.getTags().add(tag);
        this.albumService.create(album);
        return String.format("Tag %s added to Album %s", tagName, albumName);
    }
}
