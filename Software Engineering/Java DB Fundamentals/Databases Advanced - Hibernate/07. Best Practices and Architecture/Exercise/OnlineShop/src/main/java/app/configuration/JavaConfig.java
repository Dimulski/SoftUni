package app.configuration;

import app.domain.factories.LineItemFactory;
import app.domain.factories.LocationFactory;
import app.domain.factories.OrderFactory;
import app.domain.factories.ProductFactory;
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
