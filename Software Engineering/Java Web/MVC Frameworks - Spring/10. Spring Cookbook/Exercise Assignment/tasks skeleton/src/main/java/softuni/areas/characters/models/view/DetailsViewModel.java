package softuni.areas.characters.models.view;

import softuni.areas.tasks.models.view.TimerViewModel;

public class DetailsViewModel {
    private String level;
    private String type;

    private TimerViewModel activeTask;

    public TimerViewModel getActiveTask() {
        return activeTask;
    }

    public void setActiveTask(TimerViewModel activeTask) {
        this.activeTask = activeTask;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
