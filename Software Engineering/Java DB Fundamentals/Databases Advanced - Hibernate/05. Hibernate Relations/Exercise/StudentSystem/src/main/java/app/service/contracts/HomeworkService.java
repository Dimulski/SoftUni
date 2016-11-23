package app.service.contracts;

import app.domain.Homework;

import java.util.List;

public interface HomeworkService {

    void save(Homework homework);

    void delete(Homework homework);

    void delete(long id);

    Homework getAHomework(long id);

    List<Homework> getHomework();
}
