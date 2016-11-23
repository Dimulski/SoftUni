package app.service.contracts;

import app.domain.Resource;

import java.util.List;

public interface ResourceService {

    void save(Resource resource);

    void delete(Resource resource);

    void delete(long id);

    Resource getResource(long id);

    List<Resource> getResources();
}
