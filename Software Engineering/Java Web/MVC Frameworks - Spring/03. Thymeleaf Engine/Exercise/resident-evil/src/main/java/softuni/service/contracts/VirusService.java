package softuni.service.contracts;

import softuni.models.VirusBindingModel;

public interface VirusService {

    void create(VirusBindingModel virusBindingModel);
    String getGeoData();
}
