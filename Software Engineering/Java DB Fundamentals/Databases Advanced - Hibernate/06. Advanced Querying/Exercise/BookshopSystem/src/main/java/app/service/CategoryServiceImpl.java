package app.service;

import app.domain.Category;
import app.repositories.CategoryRepository;
import app.service.contracts.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void save(Category category) {
        this.categoryRepository.save(category);
    }

    @Override
    public void delete(Category category) {
        this.categoryRepository.delete(category);
    }

    @Override
    public void delete(long id) {
        this.categoryRepository.delete(id);
    }

    @Override
    public Category getCategory(long id) {
        return this.categoryRepository.findById(id);
    }

    @Override
    public Iterable<Category> getCategories() {
        return this.categoryRepository.findAll();
    }
}
