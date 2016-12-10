package app.service.contracts;

import app.domain.dtos.CategoryJsonDto;
import app.domain.queryDtos.CategoryStatsDto;

import java.util.List;

public interface CategoryService {

    void create(CategoryJsonDto categoryJsonDto);

    CategoryJsonDto findById(long id);

    int getCount();

    List<CategoryStatsDto> getCategoryStats();
}
