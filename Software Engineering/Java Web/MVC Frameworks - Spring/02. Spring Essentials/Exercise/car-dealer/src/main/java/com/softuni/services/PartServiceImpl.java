package com.softuni.services;

import com.softuni.entities.Part;
import com.softuni.models.bindingModels.part.AddPartModel;
import com.softuni.models.bindingModels.part.EditPartModel;
import com.softuni.models.bindingModels.part.PartModel;
import com.softuni.models.viewModels.part.PartView;
import com.softuni.repositories.PartRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PartServiceImpl implements PartService {

    @Autowired
    private PartRepository partRepository;

    @Override
    public List<PartView> getAll() {
        List<PartView> partViews = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        List<Part> parts = this.partRepository.findAll();
        for (Part part : parts) {
            PartView partView = modelMapper.map(part, PartView.class);
            partViews.add(partView);
        }

        return partViews;
    }

    @Override
    public void persist(AddPartModel partModel) {
        ModelMapper modelMapper = new ModelMapper();
        Part part = modelMapper.map(partModel, Part.class);
        this.partRepository.saveAndFlush(part);
    }

    @Override
    public EditPartModel getById(Long id) {
        EditPartModel editPartModel = new EditPartModel();
        Part part = this.partRepository.findOne(id);
        if (part != null) {
            ModelMapper modelMapper = new ModelMapper();
            editPartModel = modelMapper.map(part, EditPartModel.class);
        }

        return editPartModel;
    }

    @Override
    public void update(EditPartModel editPartModel) {
        this.partRepository.update(editPartModel.getPrice(), editPartModel.getQuantity(), editPartModel.getId());
    }

    @Override
    public PartModel getByName(String name) {
        Part part = this.partRepository.findByName(name);
        PartModel partModel = null;
        if (part != null) {
            ModelMapper modelMapper = new ModelMapper();
            partModel = modelMapper.map(part, PartModel.class);
        }

        return partModel;
    }

    @Override
    public PartView getViewById(Long id) {
        PartView partView = null;
        Part part = this.partRepository.findOne(id);
        if (part != null) {
            ModelMapper modelMapper = new ModelMapper();
            partView = modelMapper.map(part, PartView.class);
        }

        return partView;
    }

    @Override
    public void delete(EditPartModel editPartModel) {
        this.partRepository.delete(editPartModel.getId());
    }
}
