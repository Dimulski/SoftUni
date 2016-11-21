package exercises.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import exercises.domain.homeworks.Homework;

import javax.persistence.NamedQuery;
import java.util.List;

@Repository
public interface HomeworkDao extends JpaRepository<Homework,Long> {

    @Query(value = "SELECT s.name, h.content, h.contentType FROM Homework AS h INNER JOIN h.student AS s")
    List<Object[]> getNameAndContent();
}