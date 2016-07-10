package app.items;

/**
 * Created by RoYaL on 7/6/2016.
 */
public class Toy {

    private double cost;

    public Toy(double cost) {
        this.setCost(cost);
    }

    public double getCost() {
        return cost;
    }

    private void setCost(double cost) {
        this.cost = cost;
    }
}
