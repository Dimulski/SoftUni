package softuni.areas.tasks.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import softuni.areas.characters.entities.Character;
import softuni.areas.tasks.entities.Task;
import softuni.areas.tasks.enums.Status;
import softuni.areas.tasks.enums.TaskType;
import softuni.areas.tasks.models.binding.CreateBindingModel;
import softuni.areas.tasks.models.view.CheckerViewModel;
import softuni.areas.tasks.models.view.ListModel;
import softuni.areas.tasks.models.view.TaskInfoModel;
import softuni.areas.tasks.models.view.TimerViewModel;
import softuni.areas.tasks.repositories.TaskRepository;
import softuni.areas.tasks.utils.Time;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    private final ModelMapper modelMapper;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository, ModelMapper modelMapper) {
        this.taskRepository = taskRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<ListModel> getAll() {
        List<Task> tasks = this.taskRepository.findAll();

        return this.getListModels(tasks);
    }

    @Override
    public void create(CreateBindingModel createBindingModel) {
        Task task = new Task();
        this.modelMapper.map(createBindingModel, task);

        task.setTime(Time.toMillis(createBindingModel.getHours(), createBindingModel.getMinutes()));

        this.taskRepository.save(task);
    }

    @Override
    public TaskInfoModel getInfoById(Long id) {
        Task task = this.taskRepository.findOne(id);
        TaskInfoModel tim = new TaskInfoModel();
        this.modelMapper.map(task, tim);

        return tim;
    }

    @Override
    public List<ListModel> getAvailable() {
        List<Task> ents = this.taskRepository.findTasksByStatus(Status.INACTIVE);

        return this.getListModels(ents);
    }

    @Override
    public List<CheckerViewModel> getActive() {
        List<Task> tasks = this.taskRepository.findTasksByStatus(Status.IN_PROGRESS);
        List<CheckerViewModel> taskList = new ArrayList<>();

        for (Task task : tasks) {
            CheckerViewModel obj = new CheckerViewModel();
            this.modelMapper.map(task, obj);
            taskList.add(obj);
        }

        return taskList;
    }

    private List<ListModel> getListModels(List<Task> tasks) {
        List<ListModel> taskList = new ArrayList<>();

        for (Task task : tasks) {
            ListModel obj = new ListModel();
            this.modelMapper.map(task, obj);
            obj.setHours(TimeUnit.MILLISECONDS.toHours(task.getTime()));
            obj.setMinutes(TimeUnit.MILLISECONDS.toMinutes(task.getTime()) % 60);
            taskList.add(obj);
        }

        return taskList;
    }

    @Transactional
    public void generateTaskOutcome(Long id) {
        Task task = this.taskRepository.findOne(id);

        Random random = new Random();
        float chance = random.nextFloat();

        if (chance <= 0.60f) {
            task.setStatus(Status.FAILED);
            task.getCharacter().addXp(task.getXp() / 10);
        } else {
            task.setStatus(Status.SUCCESS);
            task.getCharacter().addXp(task.getXp());
        }

        task.getCharacter().setOnMission(false);

        this.taskRepository.save(task);
    }

    @Override
    public Task getById(Long taskId) {
        return this.taskRepository.findOne(taskId);
    }

    @Override
    public void update(Task task) {
        this.taskRepository.save(task);
    }

    @Override
    public TaskType devType(Character character) {
        Long maxCount = 0L;
        TaskType type = null;

        for (TaskType task : TaskType.values()) {

            Long curr = this.taskRepository.countByTypeAndCharacter(task, character);

            if (curr.compareTo(maxCount) > 0) {
                maxCount = curr;
                type = task;
            }
        }

        return type;
    }

    @Override
    public TimerViewModel activeTask(Character character) {
        Task task = this.taskRepository.findTaskByCharacterAndStatus(character, Status.IN_PROGRESS);

        if(task == null){
            return null;
        }

        TimerViewModel model = new TimerViewModel();
        this.modelMapper.map(task, model);

        model.setEndDate(task.getEndDate().getTime());

        return model;
    }


}
