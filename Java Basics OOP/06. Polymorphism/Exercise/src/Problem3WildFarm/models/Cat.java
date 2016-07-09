package Problem3WildFarm.models;

import java.text.DecimalFormat;

public class Cat extends Feline {

    private String breed;

    public Cat(String animalType, String animalName, Double animalWeight, String livingRegion, String breed) {
        super(animalType, animalName, animalWeight, livingRegion);
        this.setBreed(breed);
    }

    private String getBreed() {
        return this.breed;
    }

    private void setBreed(String breed) {
        this.breed = breed;
    }

    @Override
    public void makeSound() {
        System.out.println("Meowwww");
    }

    @Override
    public void eat(Food food) {
        if (food.getClass().getSimpleName().equals("Meat") || food.getClass().getSimpleName().equals("Vegetable")) {
            this.setFoodEaten(getFoodEaten() + food.getQuantity());
        } else {
            throw new IllegalArgumentException("Cats are not eating that type of food!");
        }
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.######");
        return String.format("%s[%s, %s, %s, %s, %s]",
                this.getClass().getSimpleName(),
                this.getAnimalName(),
                this.getBreed(),
                df.format(this.getAnimalWeight()),
                this.getLivingRegion(),
                this.getFoodEaten());
    }
}
