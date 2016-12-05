package com.onlineshop.service;

import com.onlineshop.domain.model.LineItem;
import com.onlineshop.domain.model.Order;
import com.onlineshop.domain.model.Product;

public interface LineItemService {

    LineItem create(Order order, long quantity, Product product);
}
