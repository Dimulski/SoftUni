package Problem3WildFarm.models;

public abstract class Food {
    private Integer quantity;

    Food(Integer quantity) {
        this.setQuantity(quantity);
    }

    Integer getQuantity() {
        return this.quantity;
    }

    private void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
