package app.service;

import app.domain.dtos.ProductDto;
import app.domain.models.Product;
import app.domain.queryDtos.ProductSellerDto;
import app.repositories.ProductRepository;
import app.repositories.UserRepository;
import app.service.contracts.ProductService;
import app.service.contracts.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @Override
    public void create(ProductDto productJsonDto) {
        this.productRepository.saveAndFlush(this.convertToEntity(productJsonDto));
    }

    @Override
    public ProductDto findById(long id) {
        return this.convertToDto(this.productRepository.findOne(id));
    }

    @Override
    public int getCount() {
        return (int) this.productRepository.count();
    }

    @Override
    public List<ProductSellerDto> getProductsInRangeWithoutBuyer() {
        List<ProductSellerDto> productSellerDtos = new ArrayList<>();
        for (Object[] element : this.productRepository.findProductsInRangeWithoutBuyer()) {
            ProductSellerDto productSellerDto = new ProductSellerDto();
            productSellerDto.setName((String) element[0]);
            productSellerDto.setPrice((BigDecimal) element[1]);
            productSellerDto.setSeller((String) element[2]);
            productSellerDtos.add(productSellerDto);
        }

        return productSellerDtos;
    }

    private ProductDto convertToDto(Product product) {
        ProductDto productJsonDto = new ProductDto();
        productJsonDto.setName(product.getName());
        productJsonDto.setPrice(product.getPrice());

        Random random = new Random();
        int max = (int) this.userRepository.count();
        int min = 1;
        productJsonDto.setSeller(this.userService.findById(random.nextInt(max) + min));
        if (random.nextInt(20) < 19) {
            productJsonDto.setBuyer(this.userService.findById(random.nextInt(max) + min));
        }

        return productJsonDto;
    }

    private Product convertToEntity(ProductDto productJsonDto) {
        Product product = new Product();
        product.setName(productJsonDto.getName());
        product.setPrice(productJsonDto.getPrice());

        Random random = new Random();
        int max = (int) this.userRepository.count();
        int min = 1;
        product.setSeller(this.userRepository.getOne((long) (random.nextInt(max) + min)));
        if (random.nextInt(20) < 19) {
            product.setBuyer(this.userRepository.getOne((long) (random.nextInt(max) + min)));
        }

        return product;
    }
}
