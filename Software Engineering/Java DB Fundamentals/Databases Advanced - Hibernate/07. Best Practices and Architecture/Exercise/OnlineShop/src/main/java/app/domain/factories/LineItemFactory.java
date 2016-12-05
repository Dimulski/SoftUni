package app.domain.factories;


import app.domain.models.Order;
import app.domain.models.LineItem;
import app.domain.models.Product;

public class LineItemFactory {

    public LineItem create(long quantity, Product product, Order order){
        LineItem lineItem = new LineItem();
        lineItem.setProduct(product);
        lineItem.setOrder(order);
        lineItem.setQuantity(quantity);
        return lineItem;
    }
}
