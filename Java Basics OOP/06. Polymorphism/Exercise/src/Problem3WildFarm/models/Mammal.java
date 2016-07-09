package Problem3WildFarm.models;

import java.text.DecimalFormat;

abstract class Mammal extends Animal{
    private String livingRegion;

    Mammal(String animalType, String animalName, Double animalWeight, String livingRegion) {
        super(animalType, animalName, animalWeight);
        this.setLivingRegion(livingRegion);
    }

    String getLivingRegion() {
        return this.livingRegion;
    }

    private void setLivingRegion(String livingRegion) {
        this.livingRegion = livingRegion;
    }

    public abstract void makeSound();

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.######");
        return String.format("%s[%s, %s, %s, %s]",
                this.getClass().getSimpleName(),
                this.getAnimalName(),
                df.format(this.getAnimalWeight()),
                this.getLivingRegion(),
                this.getFoodEaten());
    }
}
