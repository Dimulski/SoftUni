package softuni.service.contracts;

import softuni.models.bindingModels.AddVirusBindingModel;
import softuni.models.bindingModels.EditVirusBindingModel;
import softuni.models.viewModels.VirusViewModel;

import java.util.List;

public interface VirusService {

    void save(AddVirusBindingModel addVirusBindingModel);

    void save(EditVirusBindingModel editVirusBindingModel);

    List<VirusViewModel> findAllViruses();

    String findAllMapViruses();

    EditVirusBindingModel findVirusById(long virusId);

    void deleteById(long virusId);
}
