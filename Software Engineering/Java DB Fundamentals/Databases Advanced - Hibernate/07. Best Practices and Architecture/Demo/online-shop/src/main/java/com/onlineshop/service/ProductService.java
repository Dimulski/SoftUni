package com.onlineshop.service;

import com.onlineshop.domain.dto.ProductDto;
import com.onlineshop.domain.model.Product;

public interface ProductService {

    Product create(ProductDto productDto);
}
