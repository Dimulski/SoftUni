package app.service;


import app.domain.Major;

public interface MajorService {

    void create(Major major);

    void deleteByName(String name);
}
