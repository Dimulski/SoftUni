package app.service;

import app.domain.Product;
import app.repositories.ProductRepository;
import app.service.contracts.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void create(Product product) {
        this.productRepository.saveAndFlush(product);
    }
}
