package app.service;

import app.domain.Album;
import app.repositories.AlbumRepository;
import app.service.contracts.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumServiceImpl implements AlbumService {

    @Autowired
    private AlbumRepository albumRepository;

    @Override
    public void create(Album album) {
        this.albumRepository.saveAndFlush(album);
    }
}
