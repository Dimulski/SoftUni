package app.repository;

import app.domain.Homework;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomeworkRepository extends JpaRepository<Homework, Long> {

    Homework findById(long id);

    List<Homework> findAll();
}
