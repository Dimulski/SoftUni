package com.residentevil.services;

import com.residentevil.models.bindingModels.AddVirusBindingModel;
import com.residentevil.models.bindingModels.EditVirusBindingModel;
import com.residentevil.models.viewModels.VirusViewModel;

import java.util.List;

public interface VirusService {

    void save(AddVirusBindingModel addVirusBindingModel);

    void save(EditVirusBindingModel editVirusBindingModel);

    List<VirusViewModel> findAllViruses();

    String findAllMapViruses();

    EditVirusBindingModel findVirusById(long virusId);

    void deleteById(long virusId);
}
