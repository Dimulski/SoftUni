package app.service.contracts;

import app.domain.dtos.ProductDto;
import app.domain.models.Product;

public interface ProductService {

    Product create(ProductDto productDto);
}
