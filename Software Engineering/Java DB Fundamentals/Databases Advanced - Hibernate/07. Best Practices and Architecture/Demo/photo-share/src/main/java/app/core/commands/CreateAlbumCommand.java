package app.core.commands;

import app.domain.model.*;
import app.service.AlbumRoleService;
import app.service.AlbumService;
import app.service.TagService;
import app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class CreateAlbumCommand extends Command {

    @Autowired
    private AlbumService albumService;

    @Autowired
    private TagService tagService;

    @Autowired
    private AlbumRoleService albumRoleService;

    @Autowired
    private UserService userService;

    protected CreateAlbumCommand(String[] data) {
        super(data);
    }

    /**
     * CreateAlbum <username> <albumTitle> <BackgroundColor> <tag1> <tag2>...<tagN>
     */
    @Override
    public String execute() {
        Album album = new Album();
        AlbumRole albumRole = new AlbumRole();
        String username = super.getData()[1];
        User user = this.userService.findByUsername(username);
        String albumTitle = super.getData()[2];
        Color backgroundColor = Color.valueOf(super.getData()[3]);
        album.setName(albumTitle);
        album.setBackgroundColor(backgroundColor);
        albumRole.setUser(user);
        album.getAlbumRoles().add(albumRole);
        for (int i = 4; i < super.getData().length; i++) {
            String tagName = super.getData()[i];
            Tag tag = this.tagService.findByName(tagName);
            album.getTags().add(tag);
        }

        this.albumService.create(album);
        return String.format("The album has been created");
    }
}
