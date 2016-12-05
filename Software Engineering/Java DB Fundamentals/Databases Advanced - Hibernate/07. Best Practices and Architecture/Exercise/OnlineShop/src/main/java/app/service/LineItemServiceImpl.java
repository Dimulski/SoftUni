package app.service;

import app.domain.factories.LineItemFactory;
import app.domain.models.LineItem;
import app.domain.models.Order;
import app.domain.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.service.contracts.LineItemService;

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
