package com.softuni.services;

import com.softuni.models.bindingModels.part.AddPartModel;
import com.softuni.models.bindingModels.part.EditPartModel;
import com.softuni.models.bindingModels.part.PartModel;
import com.softuni.models.viewModels.part.PartView;

import java.util.List;

public interface PartService {

    List<PartView> getAll();
    void persist(AddPartModel part);
    EditPartModel getById(Long id);
    void update(EditPartModel editPartModel);
    PartModel getByName(String name);
    PartView getViewById(Long id);
    void delete(EditPartModel id);
}
