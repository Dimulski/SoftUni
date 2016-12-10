package app.service.contracts;

import app.domain.dtos.CategoryDto;
import app.domain.queryDtos.CategoryStatsDto;

import java.util.List;

public interface CategoryService {

    void create(CategoryDto categoryJsonDto);

    CategoryDto findById(long id);

    int getCount();

    List<CategoryStatsDto> getCategoryStats();
}
