package Problem4MordorsCrueltyPlan.models;

public class Food {
    private String name;
    private Integer pointsOfHappiness;

    Food(String name, Integer pointsOfHappiness) {
        this.setName(name);
        this.setPointsOfHappiness(pointsOfHappiness);
    }

    private String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    Integer getPointsOfHappiness() {
        return this.pointsOfHappiness;
    }

    private void setPointsOfHappiness(Integer pointsOfHappiness) {
        this.pointsOfHappiness = pointsOfHappiness;
    }
}
