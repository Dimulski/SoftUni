package app.service;

import app.service.contracts.ProductService;
import app.domain.dtos.ProductDto;
import app.domain.factories.ProductFactory;
import app.domain.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductFactory productFactory;

    @Override
    public Product create(ProductDto productDto) {
        String name = productDto.getName();
        BigDecimal price = productDto.getPrice();
        Product product = this.productFactory.create(name, price);
        return product;
    }
}
