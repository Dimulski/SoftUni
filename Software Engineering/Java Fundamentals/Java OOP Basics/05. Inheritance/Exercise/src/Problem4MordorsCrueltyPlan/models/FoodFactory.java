package Problem4MordorsCrueltyPlan.models;

public abstract class FoodFactory {

    public static Food createFood(String foodName) {
        switch (foodName.toLowerCase()) {
            case "cram": return new Food(foodName, 2);
            case "lembas": return new Food(foodName, 3);
            case "apple": return new Food(foodName, 1);
            case "melon": return new Food(foodName, 1);
            case "honeycake": return new Food(foodName, 5);
            case "mushrooms": return new Food(foodName, -10);
            default: return new Food(foodName, -1);
        }
    }
}
