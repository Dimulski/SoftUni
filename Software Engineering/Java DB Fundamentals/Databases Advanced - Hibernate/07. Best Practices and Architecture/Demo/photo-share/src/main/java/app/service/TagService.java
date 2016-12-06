package app.service;

import app.domain.model.Tag;

public interface TagService {

    void create(Tag tag);

    Tag findByName(String name);
}
