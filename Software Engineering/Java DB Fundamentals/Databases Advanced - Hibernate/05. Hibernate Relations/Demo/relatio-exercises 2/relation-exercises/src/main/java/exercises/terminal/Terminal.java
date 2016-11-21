package exercises.terminal;

import exercises.dataFactory.DataFactory;
import exercises.domain.albums.Album;
import exercises.repositories.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Terminal implements CommandLineRunner {

    @Autowired
    private DataFactory dataFactory;

    @Autowired
    private AlbumRepository albumRepository;

    @Override
    public void run(String... strings) throws Exception {

        Album album = new Album();
        album.setTag("#randomtag");
        albumRepository.saveAndFlush(album);
    }
}