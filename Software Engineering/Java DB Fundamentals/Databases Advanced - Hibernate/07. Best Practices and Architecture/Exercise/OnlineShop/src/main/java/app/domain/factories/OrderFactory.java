package app.domain.factories;

import app.domain.models.Location;
import app.domain.models.Order;

import java.util.Date;

public class OrderFactory {

    public Order create(Location location, Date orderDate){
        Order order = new Order();
        order.setLocation(location);
        order.setOrderDate(orderDate);
        return order;
    }
}
