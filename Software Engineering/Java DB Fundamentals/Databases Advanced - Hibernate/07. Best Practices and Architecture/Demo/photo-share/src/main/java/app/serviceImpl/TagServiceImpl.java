package app.serviceImpl;

import app.domain.model.Tag;
import app.repository.TagRepository;
import app.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    public void create(Tag tag) {
        this.tagRepository.save(tag);
    }

    @Override
    public Tag findByName(String name) {
        return this.tagRepository.findByName(name);
    }
}
