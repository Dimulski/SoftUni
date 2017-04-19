package softuni.areas.tasks.models.binding;

import lombok.Getter;
import lombok.Setter;
import softuni.areas.tasks.enums.TaskType;

public class CreateBindingModel {

    @Getter
    @Setter
    private TaskType type;

    @Getter
    @Setter
    private String description;

    @Getter
    @Setter
    private String title;

    @Getter
    @Setter
    private Long xp;

    private Integer hours;

    private Integer minutes;

    public Integer getHours() {
        return hours;
    }

    public void setHours(Integer hours) {
        this.hours = hours;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }
}
