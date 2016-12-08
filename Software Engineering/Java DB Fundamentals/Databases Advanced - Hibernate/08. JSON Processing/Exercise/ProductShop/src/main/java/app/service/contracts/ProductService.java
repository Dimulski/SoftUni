package app.service.contracts;

import app.domain.dtos.ProductJsonDto;
import app.domain.queryDtos.ProductSellerDto;

import java.util.List;

public interface ProductService {

    void create(ProductJsonDto productJsonDto);

    ProductJsonDto findById(long id);

    int getCount();

    List<ProductSellerDto> getProductsInRangeWithoutBuyer();
}
