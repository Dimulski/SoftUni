package Problem4MordorsCrueltyPlan.models;

public class Mood {
    private String name;
    private Integer points;

    Mood(Integer points) {
        this.setPoints(points);
        this.setName();
    }

    public String getName() {
        return this.name;
    }

    private void setName() {
        if (getPoints() < -5) {
            this.name = "Angry";
        } else if (getPoints() >= -5 && getPoints() < 0) {
            this.name = "Sad";
        } else if (getPoints() >= 0 && getPoints() <= 15) {
            this.name = "Happy";
        } else if (getPoints() > 15) {
            this.name = "JavaScript";
        }
    }

    public Integer getPoints() {
        return this.points;
    }
    private void setPoints(Integer points) {
        this.points = points;
    }
}
