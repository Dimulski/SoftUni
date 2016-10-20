package Problem4MordorsCrueltyPlan;

import Problem4MordorsCrueltyPlan.models.Food;
import Problem4MordorsCrueltyPlan.models.FoodFactory;
import Problem4MordorsCrueltyPlan.models.Mood;
import Problem4MordorsCrueltyPlan.models.MoodFactory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        List<String> foodNames = Arrays.asList(reader.readLine().toLowerCase().split("\\s+"));
        List<Food> foods = new ArrayList<>();
        for (String foodName : foodNames) {
            Food food = FoodFactory.createFood(foodName);
            foods.add(food);
        }
        Mood gandalfsMood = MoodFactory.createMood(foods);
        System.out.println(gandalfsMood.getPoints());
        System.out.println(gandalfsMood.getName());
    }
}
