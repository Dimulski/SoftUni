package app.terminal;

import app.domain.*;
import app.service.contracts.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;

@Component
public class Terminal implements CommandLineRunner {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private ProductService productService;

    @Autowired
    private SaleService saleService;

    @Autowired
    private StoreLocationService storeLocationService;

    @Override
    public void run(String... strings) throws Exception {

        Customer customer = new Customer();
        customer.setName("Georgi");
        customer.setEmail("georgi@abv.bg");
        customer.setCreditCardNumber("5105105105105100");
        Product product = new Product();
        product.setName("Corsair Vengeance");
        product.setPrice(135.98);
        product.setQuantity(1);
        StoreLocation storeLocation = new StoreLocation();
        storeLocation.setLocationName("amazon.com");
        Sale sale = new Sale();
        sale.setProduct(product);
        sale.setCustomer(customer);
        sale.setStoreLocation(storeLocation);
        sale.setDate(new SimpleDateFormat("yyyy-MM-dd").parse("2016-12-04"));

        this.customerService.create(customer);
        this.productService.create(product);
        this.storeLocationService.create(storeLocation);
        this.saleService.create(sale);
    }
}
