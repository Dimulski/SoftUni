package app.service;

import app.domain.models.Location;
import app.domain.models.Order;
import app.repositories.OrderRepository;
import app.service.contracts.OrderService;
import app.domain.factories.OrderFactory;
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
    public Order create(Location location, Date date) {
        Order order = this.orderFactory.create(location, date);
        this.create(order);
        return order;
    }

    @Override
    public Order create(Order order) {
        this.orderRepository.saveAndFlush(order);
        return order;
    }
}

