package com.onlineshop.service;

import com.onlineshop.domain.model.Location;
import com.onlineshop.domain.model.Order;

import java.util.Date;

public interface OrderService {

    Order create(Location location, Date date);

    Order create(Order order);
}
