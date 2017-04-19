package softuni.services;

import softuni.areas.characters.models.view.CharacterAjaxModel;
import softuni.areas.characters.models.view.CharacterMoneyModel;

public interface SocketService {
     void sendMoneyUpdate(CharacterMoneyModel character);

     void sendCharUpdate(CharacterAjaxModel character);
}
