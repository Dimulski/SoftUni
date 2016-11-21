package exercises.repositories;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import exercises.domain.resources.Resource;

@Repository
public interface ResourceDao extends JpaRepository<Resource,Long> {
}