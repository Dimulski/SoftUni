package softuni.areas.characters.controllers;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import softuni.areas.characters.models.binding.CharacterCreateModel;
import softuni.areas.characters.models.view.DetailsViewModel;
import softuni.areas.characters.services.CharacterService;
import softuni.areas.tasks.services.TaskService;

import javax.validation.Valid;
import java.security.Principal;

@Controller
@RequestMapping("characters")
@PreAuthorize("isAuthenticated()")
public class CharacterController {

    private final CharacterService characterService;

    private final Gson gson;

    @Autowired
    public CharacterController(CharacterService characterService, Gson gson) {
        this.characterService = characterService;
        this.gson = gson;
    }

    @PostMapping("create")
    public String create(@Valid CharacterCreateModel ccm, Principal auth) {
        this.characterService.create(ccm, auth.getName());

        return "redirect:/users/characters";
    }

    @GetMapping("create")
    public String createView(Model model, CharacterCreateModel ccm) {
        model.addAttribute("view", "characters/create");
        model.addAttribute("model", ccm);

        return "base-layout";
    }

    @GetMapping("{id}")
    @ResponseBody
    public String createView(@PathVariable Long id) {
        DetailsViewModel detailsViewModel = this.characterService.getDetails(id);

        return this.gson.toJson(detailsViewModel);
    }

    @GetMapping("ranking")
    public String ranking(Model model) {
        model.addAttribute("view", "characters/ranking");
        model.addAttribute("characters", this.characterService.topCharacters());

        return "base-layout";
    }

    @GetMapping("/{cid}/task/{tid}")
    @ResponseBody
    public String assignTask(@PathVariable Long cid, @PathVariable Long tid) {
        this.characterService.assignTask(cid, tid);

        return "completed";
    }
}
