package app.service.contracts;

import app.domain.models.LineItem;
import app.domain.models.Order;
import app.domain.models.Product;

public interface LineItemService {

    LineItem create(Order order, long quantity, Product product);
}
