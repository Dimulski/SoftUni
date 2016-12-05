package com.onlineshop.configuration;

import com.onlineshop.domain.dto.ProductDto;
import com.onlineshop.domain.factory.LineItemFactory;
import com.onlineshop.domain.factory.LocationFactory;
import com.onlineshop.domain.factory.OrderFactory;
import com.onlineshop.domain.factory.ProductFactory;
import com.onlineshop.domain.model.LineItem;
import com.onlineshop.domain.model.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

    @Bean
    public ProductFactory productFactory(){
        return new ProductFactory();
    }

    @Bean
    public LineItemFactory lineItemFactory(){
        return new LineItemFactory();
    }

    @Bean
    public OrderFactory orderFactoryFactory(){
        return new OrderFactory();
    }

    @Bean
    public LocationFactory locationFactory(){
        return new LocationFactory();
    }
}
