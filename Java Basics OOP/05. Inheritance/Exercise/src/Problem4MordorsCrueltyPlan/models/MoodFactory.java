package Problem4MordorsCrueltyPlan.models;

import java.util.List;

public abstract class MoodFactory {
    private static Integer points = 0;

    public static Mood createMood(List<Food> foods) {
        for (Food food : foods) {
            points += food.getPointsOfHappiness();
        }
        return new Mood(points);
    }
}
