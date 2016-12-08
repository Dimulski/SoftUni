package app.service;

import app.domain.dtos.CategoryJsonDto;
import app.domain.models.Category;
import app.repositories.CategoryRepository;
import app.service.contracts.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void create(CategoryJsonDto categoryJsonDto) {
        Category category = this.convertToEntity(categoryJsonDto);
        this.categoryRepository.saveAndFlush(category);
    }

    @Override
    public CategoryJsonDto findById(long id) {
        Category category = this.categoryRepository.findOne(id);
        CategoryJsonDto categoryJsonDto = this.convertToDto(category);
        return categoryJsonDto;
    }

    @Override
    public int getCount() {
        return (int) this.categoryRepository.count();
    }

    private CategoryJsonDto convertToDto(Category category) {
        CategoryJsonDto categoryJsonDto = new CategoryJsonDto();
        categoryJsonDto.setName(category.getName());
        return categoryJsonDto;
    }

    private Category convertToEntity(CategoryJsonDto categoryJsonDto) {
        Category category = new Category();
        category.setName(categoryJsonDto.getName());
        return category;
    }
}
