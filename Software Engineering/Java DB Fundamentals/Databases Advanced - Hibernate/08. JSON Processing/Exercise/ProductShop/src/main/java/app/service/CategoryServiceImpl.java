package app.service;

import app.domain.dtos.CategoryJsonDto;
import app.domain.models.Category;
import app.domain.queryDtos.CategoryStatsDto;
import app.repositories.CategoryRepository;
import app.service.contracts.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<CategoryStatsDto> getCategoryStats() {
        List<CategoryStatsDto> categoryStatsDtos = new ArrayList<>();
        List<Object[]> categoryStats = this.categoryRepository.findCategoryStats();
        for (Object[] stat : categoryStats) {
            CategoryStatsDto categoryStatsDto = new CategoryStatsDto();
            categoryStatsDto.setCategory((String) stat[0]);
            categoryStatsDto.setProductsCount((Integer) stat[1]);
            categoryStatsDto.setAveragePrice((BigDecimal.valueOf((double) stat[2])));
            categoryStatsDto.setTotalRevenue((BigDecimal.valueOf(Double.valueOf(String.valueOf(stat[3])))));
            categoryStatsDtos.add(categoryStatsDto);
        }

        return categoryStatsDtos;
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
