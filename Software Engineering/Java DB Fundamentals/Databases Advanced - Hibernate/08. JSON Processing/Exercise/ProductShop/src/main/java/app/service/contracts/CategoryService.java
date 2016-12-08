package app.service.contracts;

import app.domain.dtos.CategoryJsonDto;

public interface CategoryService {

    void create(CategoryJsonDto categoryJsonDto);

    CategoryJsonDto findById(long id);

    int getCount();
}
