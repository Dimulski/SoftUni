package app.core.commands;

import app.domain.model.Album;
import app.domain.model.Color;
import app.service.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;

public class ModifyAlbumCommand extends Command {

    @Autowired
    private AlbumService albumService;

    protected ModifyAlbumCommand(String[] data) {
        super(data);
    }

    /**
     * ModifyAlbum <albumId> <property> <new value>
     * For example
     * ModifyAlbum Name <new name>
     * ModifyAlbum BackgroundColor <new color>
     * ModifyAlbum IsPublic <True/False>
     */
    @Override
    public String execute() {
        int id = Integer.parseInt(super.getData()[1]);
        String field = super.getData()[2];
        Album album = this.albumService.find(id);

        switch(field){
            case "Name":
                String name = super.getData()[3];
                album.setName(name);
                break;
            case "BackgroundColor":
                Color color = Color.valueOf(super.getData()[3]);
                album.setBackgroundColor(color);
                break;
            case "IsPublic":
                boolean isPublic = Boolean.parseBoolean(super.getData()[3]);
                album.setPublic(isPublic);
                break;
        }

        this.albumService.create(album);
        return "Album Modified";
    }
}
