package exercises.repositories;

import exercises.domain.albums.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.lang.annotation.Retention;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long> {
}
