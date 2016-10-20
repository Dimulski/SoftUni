package Problem3WildFarm.models;

public class Tiger extends Feline {

    public Tiger(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("ROAAR!!!");
    }

    @Override
    public void eat(Food food) {
        if (food.getClass().getSimpleName().equals("Meat")) {
            this.setFoodEaten(getFoodEaten() + food.getQuantity());
        } else {
            throw new IllegalArgumentException("Tigers are not eating that type of food!");
        }
    }
}
