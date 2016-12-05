package com.onlineshop.controller;

import com.onlineshop.domain.dto.ProductDto;
import com.onlineshop.domain.model.LineItem;
import com.onlineshop.domain.model.Location;
import com.onlineshop.domain.model.Order;
import com.onlineshop.domain.model.Product;
import com.onlineshop.service.LineItemService;
import com.onlineshop.service.LocationService;
import com.onlineshop.service.OrderService;
import com.onlineshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
