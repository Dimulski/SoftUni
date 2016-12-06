package app.service;

import app.domain.model.Album;

public interface AlbumService {

    void create(Album album);

    Album findByName(String name);

    Album find(int id);
}
