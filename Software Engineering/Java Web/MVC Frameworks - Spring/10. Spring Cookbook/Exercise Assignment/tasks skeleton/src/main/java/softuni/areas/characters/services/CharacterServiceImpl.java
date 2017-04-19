package softuni.areas.characters.services;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import softuni.areas.characters.entities.Character;
import softuni.areas.characters.enums.CharacterLevel;
import softuni.areas.characters.enums.CharacterType;
import softuni.areas.characters.models.binding.CharacterCreateModel;
import softuni.areas.characters.models.view.CharacterAjaxModel;
import softuni.areas.characters.models.view.CharacterViewModel;
import softuni.areas.characters.models.view.CharacterMoneyModel;
import softuni.areas.characters.models.view.DetailsViewModel;
import softuni.areas.characters.repositories.CharacterRepository;
import softuni.areas.tasks.entities.Task;
import softuni.areas.tasks.enums.Status;
import softuni.areas.tasks.models.view.TaskInfoModel;
import softuni.areas.tasks.services.TaskService;
import softuni.areas.users.services.GameUserService;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService {

    private final CharacterRepository characterRepository;
    private final ModelMapper modelMapper;
    private final GameUserService userService;
    private final TaskService taskService;

    @Autowired
    public CharacterServiceImpl(CharacterRepository characterRepository, GameUserService gameUserService, TaskService taskService, ModelMapper modelMapper) {
        this.characterRepository = characterRepository;
        this.taskService = taskService;
        this.userService = gameUserService;
        this.modelMapper = modelMapper;
    }

    @Override
    public void create(CharacterCreateModel ccm, String email) {
        Character character = new Character();
        this.modelMapper.map(ccm, character);

        character.setOwner(this.userService.getByEmail(email));

        this.characterRepository.save(character);
    }

    @Override
    public List<CharacterViewModel> getByUserId(Long id) {
        List<Character> clvm = this.characterRepository.findByOwnerId(id);
        List<CharacterViewModel> list = new ArrayList<>();

        for (Character ch : clvm) {
            CharacterViewModel character = new CharacterViewModel();
            this.modelMapper.map(ch, character);
            list.add(character);
        }
        return list;
    }

    @Override
    public DetailsViewModel getDetails(Long id) {
        Character character = this.characterRepository.findOne(id);
        DetailsViewModel dvm = new DetailsViewModel();

        this.modelMapper.map(character, dvm);

        dvm.setActiveTask(this.taskService.activeTask(character));

        dvm.setLevel(CharacterLevel.of(character.getXp()).getName());
        dvm.setType(CharacterType.of(this.taskService.devType(character)).getType());

        return dvm;
    }

    @Override
    public List<CharacterViewModel> topCharacters() {

        List<CharacterViewModel> characters = new ArrayList<>();
        for(Character ch : this.characterRepository.findTop10ByOrderByXpDesc()){
            CharacterViewModel model = new CharacterViewModel();
            this.modelMapper.map(ch, model);
            characters.add(model);
        }

        return characters;

    }

    @Override
    public void assignTask(Long charId, Long taskId) {
        Task task = this.taskService.getById(taskId);
        Character character = this.characterRepository.findOne(charId);

        task.setCharacter(character);
        task.setStatus(Status.IN_PROGRESS);

        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.MILLISECOND, Math.toIntExact(task.getTime()));

        task.setEndDate(c.getTime());

        character.setOnMission(true);

        this.taskService.update(task);
    }

    @Override
    public List<Character> getAll() {
        return this.characterRepository.findAll();
    }

    @Override
    public void update(Character character) {
        this.characterRepository.save(character);
    }

    @Override
    public CharacterMoneyModel characterMoney(Long id) {
        Character character = this.characterRepository.findOne(id);
        CharacterMoneyModel cvm = new CharacterMoneyModel();

        this.modelMapper.map(character, cvm);

        return cvm;
    }

    @Override
    public CharacterAjaxModel characterAjax(Long taskId) {
        Character character = this.taskService.getById(taskId).getCharacter();
        CharacterAjaxModel cam = new CharacterAjaxModel();

        this.modelMapper.map(character, cam);
        cam.setLevel(CharacterLevel.of(character.getXp()).getName());

        return cam;
    }
}
