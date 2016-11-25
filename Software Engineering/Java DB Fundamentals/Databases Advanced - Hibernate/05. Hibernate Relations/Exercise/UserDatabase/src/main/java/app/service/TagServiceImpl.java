package app.service;

import app.domain.Tag;
import app.repositories.TagRepository;
import app.service.contracts.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public void create(Tag tag) {
        this.tagRepository.saveAndFlush(tag);
    }
}
