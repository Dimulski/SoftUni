package softuni.areas.characters.enums;

import softuni.areas.tasks.enums.TaskType;

import java.util.HashMap;
import java.util.Map;

public enum CharacterType {
    MOBILE_DEVELOPER      ("Mobile Developer"     , TaskType.Mobile),
    GAME_DEVELOPER        ("Game Developer"       , TaskType.Game),
    WEB_DEVELOPER         ("Web Developer"        , TaskType.Web),
    EMBEDDED_DEVELOPER    ("Embedded Developer"   , TaskType.Embedded),
    APPLICATION_DEVELOPER ("Application Developer", TaskType.Application);


    private final String type;
    private final TaskType taskType;
    private static final Map<TaskType, CharacterType> taskMap = new HashMap<>(values().length);

    CharacterType(String type, TaskType taskType) {
        this.type = type;
        this.taskType = taskType;
    }

    static {
        for (CharacterType c : values()) {
            taskMap.put(c.taskType, c);
        }
    }

    public String getType() {
        return type;
    }

    public static CharacterType of(TaskType task) {

        return taskMap.get(task);
    }
}
