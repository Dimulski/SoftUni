package com.onlineshop.domain.factory;

import com.onlineshop.domain.model.Location;
import com.onlineshop.domain.model.Order;

import java.util.Date;

public class OrderFactory {

    public Order create(Location location, Date orderDate){
        Order order = new Order();
        order.setLocation(location);
        order.setOrderDate(orderDate);
        return order;
    }
}
