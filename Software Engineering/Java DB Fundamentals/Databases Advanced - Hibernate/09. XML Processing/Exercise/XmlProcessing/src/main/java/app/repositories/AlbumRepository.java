package app.repositories;

import app.domain.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AlbumRepository extends JpaRepository<Album, Long> {



}
