package app.repository;

import app.domain.model.AlbumRole;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRoleRepository extends CrudRepository<AlbumRole, Integer> {
}
