package app.service.contracts;

import app.domain.Category;

public interface CategoryService {

    void save(Category category);

    void delete(Category category);

    void delete(long id);

    Category getCategory(long id);

    Iterable<Category> getCategories();
}
