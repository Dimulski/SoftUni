package softuni.areas.tasks.controllers;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import softuni.areas.tasks.models.binding.CreateBindingModel;
import softuni.areas.tasks.models.view.TaskInfoModel;
import softuni.areas.tasks.services.TaskService;

import javax.validation.Valid;

@Controller
@RequestMapping("tasks")
@PreAuthorize("hasRole('ADMIN')")
public class TaskController {

    private final TaskService taskService;
    private final Gson gson;

    @Autowired
    public TaskController(TaskService taskService, Gson gson) {
        this.taskService = taskService;
        this.gson = gson;
    }

    @GetMapping("/")
    public String list(Model model) {
        model.addAttribute("tasks", taskService.getAll());
        model.addAttribute("view", "tasks/list");

        return "base-layout";
    }

    @GetMapping("/{id}")
    @ResponseBody
    public String info(@PathVariable Long id) {
        TaskInfoModel taskInfoModel = this.taskService.getInfoById(id);

        return this.gson.toJson(taskInfoModel);
    }

    @GetMapping("/create")
    public String getCreate(Model model, CreateBindingModel createBindingModel) {
        model.addAttribute("model", createBindingModel);
        model.addAttribute("view", "tasks/create");

        return "base-layout";
    }

    @PostMapping("/create")
    public String create(@Valid CreateBindingModel createBindingModel) {

        this.taskService.create(createBindingModel);

        return "redirect:/tasks/";
    }

    @GetMapping("/available")
    @PreAuthorize("isAuthenticated()")
    public String availableTasks(Model model) {
        model.addAttribute("tasks", taskService.getAvailable());

        return "tasks/table :: table";
    }
}
