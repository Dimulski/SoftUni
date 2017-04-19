package softuni.areas.characters.services;

import softuni.areas.characters.entities.Character;
import softuni.areas.characters.models.binding.CharacterCreateModel;
import softuni.areas.characters.models.view.CharacterAjaxModel;
import softuni.areas.characters.models.view.CharacterViewModel;
import softuni.areas.characters.models.view.CharacterMoneyModel;
import softuni.areas.characters.models.view.DetailsViewModel;

import java.util.List;

public interface CharacterService {
    void create(CharacterCreateModel ccm, String username);
    List<CharacterViewModel> getByUserId(Long id);

    DetailsViewModel getDetails(Long id);

    List<CharacterViewModel> topCharacters();

    void assignTask(Long charId, Long taskId);

    List<Character> getAll();

    void update(Character character);

    CharacterMoneyModel characterMoney(Long id);

    CharacterAjaxModel characterAjax(Long id);
}
