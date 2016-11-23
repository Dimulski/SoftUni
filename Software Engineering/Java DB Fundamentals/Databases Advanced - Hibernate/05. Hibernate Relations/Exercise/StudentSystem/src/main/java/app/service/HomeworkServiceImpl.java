package app.service;

import app.domain.Homework;
import app.repository.HomeworkRepository;
import app.service.contracts.HomeworkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HomeworkServiceImpl implements HomeworkService {

    @Autowired
    private HomeworkRepository homeworkRepository;

    @Override
    public void save(Homework homework) {
        this.homeworkRepository.saveAndFlush(homework);
    }

    @Override
    public void delete(Homework homework) {
        this.homeworkRepository.delete(homework);
    }

    @Override
    public void delete(long id) {
        this.homeworkRepository.delete(id);
    }

    @Override
    public Homework getAHomework(long id) {
        return this.homeworkRepository.findById(id);
    }

    @Override
    public List<Homework> getHomework() {
        return this.homeworkRepository.findAll();
    }
}
