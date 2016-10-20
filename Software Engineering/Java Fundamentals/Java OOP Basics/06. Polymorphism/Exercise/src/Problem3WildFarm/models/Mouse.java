package Problem3WildFarm.models;

public class Mouse extends Mammal {

    public Mouse(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight, livingRegion);
    }

    @Override
    public void makeSound() {
        System.out.println("SQUEEEAAAK!");
    }

    @Override
    public void eat(Food food) {
        if (food.getClass().getSimpleName().equals("Vegetable")) {
            this.setFoodEaten(getFoodEaten() + food.getQuantity());
        } else {
            throw new IllegalArgumentException("Mouses are not eating that type of food!"); // horrid
        }
    }
}
