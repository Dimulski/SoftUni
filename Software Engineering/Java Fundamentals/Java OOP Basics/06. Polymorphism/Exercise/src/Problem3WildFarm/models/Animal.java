package Problem3WildFarm.models;

public abstract class Animal {
    private String animalName;
    private String animalType;
    private Double animalWeight;
    private Integer foodEaten;

    Animal(String animalType, String animalName, Double animalWeight) {
        this.setAnimalType(animalType);
        this.setAnimalName(animalName);
        this.setAnimalWeight(animalWeight);
        this.setFoodEaten(0);
    }

    String getAnimalName() {
        return this.animalName;
    }

    private void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    private String getAnimalType() {
        return this.animalType;
    }

    private void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    Double getAnimalWeight() {
        return this.animalWeight;
    }

    private void setAnimalWeight(Double animalWeight) {
        this.animalWeight = animalWeight;
    }

    Integer getFoodEaten() {
        return this.foodEaten;
    }

    void setFoodEaten(Integer foodEaten) {
        this.foodEaten = foodEaten;
    }

    public abstract void makeSound();

    public abstract void eat(Food food);
}
