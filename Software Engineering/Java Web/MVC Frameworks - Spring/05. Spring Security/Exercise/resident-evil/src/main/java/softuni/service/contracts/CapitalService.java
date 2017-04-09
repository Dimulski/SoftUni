package softuni.service.contracts;

import softuni.models.viewModels.CapitalNameViewModel;

import java.util.Set;

public interface CapitalService {

    Set<CapitalNameViewModel> getAllCapitals();
}
