package com.onlineshop.serviceImpl;

import com.onlineshop.domain.factory.LineItemFactory;
import com.onlineshop.domain.model.LineItem;
import com.onlineshop.domain.model.Order;
import com.onlineshop.domain.model.Product;
import com.onlineshop.service.LineItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LineItemServiceImpl implements LineItemService {

    @Autowired
    private LineItemFactory lineItemFactory;

    @Override
    public LineItem create(Order order, long quantity, Product product) {
        LineItem lineItem = this.lineItemFactory.create(quantity, product, order);
        return lineItem;
    }
}
