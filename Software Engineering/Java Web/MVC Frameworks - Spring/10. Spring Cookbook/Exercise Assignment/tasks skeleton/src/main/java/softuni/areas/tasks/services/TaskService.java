package softuni.areas.tasks.services;

import softuni.areas.characters.entities.Character;
import softuni.areas.tasks.entities.Task;
import softuni.areas.tasks.enums.TaskType;
import softuni.areas.tasks.models.binding.CreateBindingModel;
import softuni.areas.tasks.models.view.CheckerViewModel;
import softuni.areas.tasks.models.view.ListModel;
import softuni.areas.tasks.models.view.TaskInfoModel;
import softuni.areas.tasks.models.view.TimerViewModel;

import java.util.List;

public interface TaskService {
    List<ListModel> getAll();

    void create(CreateBindingModel createBindingModel);

    TaskInfoModel getInfoById(Long id);

    List<ListModel> getAvailable();

    List<CheckerViewModel> getActive();

    void generateTaskOutcome(Long id);

    Task getById(Long taskId);

    void update(Task task);

    TaskType devType(Character character);

    TimerViewModel activeTask(Character character);
}
