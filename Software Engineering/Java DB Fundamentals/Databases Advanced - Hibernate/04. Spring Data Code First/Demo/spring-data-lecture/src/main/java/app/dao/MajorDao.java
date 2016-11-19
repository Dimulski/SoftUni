package app.dao;

import app.domain.Major;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface MajorDao extends JpaRepository<Major, Long>{

    void deleteByName(String name);
}
