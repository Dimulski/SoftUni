package com.onlineshop.domain.factory;


import com.onlineshop.domain.model.LineItem;
import com.onlineshop.domain.model.Order;
import com.onlineshop.domain.model.Product;

public class LineItemFactory {

    public LineItem create(long quantity, Product product, Order order){
        LineItem lineItem = new LineItem();
        lineItem.setProduct(product);
        lineItem.setOrder(order);
        lineItem.setQuantity(quantity);
        return lineItem;
    }
}
