package app.controller;

import app.domain.dtos.ProductDto;
import app.domain.models.LineItem;
import app.domain.models.Location;
import app.domain.models.Order;
import app.domain.models.Product;
import app.service.contracts.LineItemService;
import app.service.contracts.LocationService;
import app.service.contracts.OrderService;
import app.service.contracts.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
public class ShopController {

    @Autowired
    private LocationService locationService;

    @Autowired
    private ProductService productService;

    @Autowired
    private LineItemService lineItemService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/shop")
    public String shopForm(Model model) {
        model.addAttribute("productDto", new ProductDto());
        return "shop";
    }

    @PostMapping("/shop")
    public String shopSubmit(@ModelAttribute ProductDto productDto) {
        Order order = this.registerOrder();
        Product product = this.createProduct(productDto);
        long quantity = productDto.getQuantity();
        this.addLineItem(order, quantity , product);
        return "shop";
    }

    private Order registerOrder() {
        Location location = this.locationService.create();
        Order order = this.orderService.create(location, new Date());
        return this.orderService.create(order);
    }

    private Product createProduct(ProductDto productDto) {
        Product product = this.productService.create(productDto);
        return product;
    }

    private void addLineItem(Order order, long quantity, Product product) {
        LineItem lineItem = this.lineItemService.create(order, quantity, product);
        order.addLineItem(lineItem);
        this.orderService.create(order);
    }
}
