package app.service.contracts;

import app.domain.models.Location;
import app.domain.models.Order;

import java.util.Date;

public interface OrderService {

    Order create(Location location, Date date);

    Order create(Order order);
}
