package app.service;

import app.domain.Resource;
import app.repository.ResourceRepository;
import app.service.contracts.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceServiceImpl implements ResourceService {

    @Autowired
    private ResourceRepository resourceRepository;

    @Override
    public void save(Resource resource) {
        this.resourceRepository.saveAndFlush(resource);
    }

    @Override
    public void delete(Resource resource) {
        this.resourceRepository.delete(resource);
    }

    @Override
    public void delete(long id) {
        this.resourceRepository.delete(id);
    }

    @Override
    public Resource getResource(long id) {
        return this.resourceRepository.findById(id);
    }

    @Override
    public List<Resource> getResources() {
        return this.resourceRepository.findAll();
    }
}
