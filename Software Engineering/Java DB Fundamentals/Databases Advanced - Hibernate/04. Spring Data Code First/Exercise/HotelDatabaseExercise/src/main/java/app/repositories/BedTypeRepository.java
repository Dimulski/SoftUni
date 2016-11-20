package app.repositories;

import app.domain.BedType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface BedTypeRepository extends JpaRepository<BedType, String> {

}
