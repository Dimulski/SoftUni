package app.service.contracts;

import app.domain.dtos.ProductDto;
import app.domain.queryDtos.ProductSellerDto;

import java.util.List;

public interface ProductService {

    void create(ProductDto productJsonDto);

    ProductDto findById(long id);

    int getCount();

    List<ProductSellerDto> getProductsInRangeWithoutBuyer();
}
