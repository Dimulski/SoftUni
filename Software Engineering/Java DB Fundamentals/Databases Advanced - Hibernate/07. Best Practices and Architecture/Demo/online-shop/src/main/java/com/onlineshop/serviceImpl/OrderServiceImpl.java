package com.onlineshop.serviceImpl;

import com.onlineshop.domain.factory.OrderFactory;
import com.onlineshop.domain.model.Location;
import com.onlineshop.domain.model.Order;
import com.onlineshop.repository.OrderRepository;
import com.onlineshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderFactory orderFactory;

    @Override
    public Order create(Location location, Date date){
        Order order = this.orderFactory.create(location, date);
        this.create(order);
        return order;
    }

    @Override
    public Order create(Order order){
        this.orderRepository.saveAndFlush(order);
        return order;
    }
}
