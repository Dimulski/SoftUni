package com.softuni.services;

import com.softuni.entities.PartSupplier;
import com.softuni.models.bindingModels.partSupplier.AddPartSupplierModel;
import com.softuni.models.bindingModels.partSupplier.EditPartSupplierModel;
import com.softuni.models.bindingModels.partSupplier.PartSupplierModel;
import com.softuni.models.viewModels.partSupplier.PartSupplierView;
import com.softuni.repositories.PartSupplierRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class PartSupplierServiceImpl implements PartSupplierService {

    @Autowired
    private PartSupplierRepository partSupplierRepository;

    @Override
    public List<PartSupplierView> getFilteredPartSuppliers(Boolean isImporter) {
        List<PartSupplier> partSuppliers = this.partSupplierRepository.findAllByIsImporter(isImporter);

        List<PartSupplierView> partSupplierViews = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for (PartSupplier partSupplier : partSuppliers) {
            PartSupplierView partSupplierView = modelMapper.map(partSupplier, PartSupplierView.class);
            partSupplierViews.add(partSupplierView);
        }

        return partSupplierViews;
    }

    @Override
    public List<PartSupplierView> getAll() {
        List<PartSupplierView> partSupplierViews = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for (PartSupplier partSupplier : this.partSupplierRepository.findAll()) {
            PartSupplierView partSupplierView = modelMapper.map(partSupplier, PartSupplierView.class);
            partSupplierViews.add(partSupplierView);
        }

        return partSupplierViews;
    }

    @Override
    public PartSupplierModel getByName(String name) {
        PartSupplier partSupplier = this.partSupplierRepository.findFirstByName(name);
        ModelMapper modelMapper = new ModelMapper();
        PartSupplierModel partSupplierModel = null;
        if (partSupplier != null){
            partSupplierModel = modelMapper.map(partSupplier, PartSupplierModel.class);
        }

        return partSupplierModel;
    }

    @Override
    public void persist(AddPartSupplierModel supplierModel) {
        ModelMapper modelMapper = new ModelMapper();
        PartSupplier supplier = modelMapper.map(supplierModel, PartSupplier.class);
        this.partSupplierRepository.saveAndFlush(supplier);
    }

    @Override
    public EditPartSupplierModel getByIdToEdit(Long id) {
        EditPartSupplierModel editSupplierModel = null;
        PartSupplier supplier = this.partSupplierRepository.findOne(id);
        if (supplier != null){
            ModelMapper modelMapper = new ModelMapper();
            editSupplierModel = modelMapper.map(supplier, EditPartSupplierModel.class);
        }
        
        return editSupplierModel;
    }

    @Override
    public void update(EditPartSupplierModel editSupplierModel) {
        PartSupplier supplier = this.partSupplierRepository.findOne(editSupplierModel.getId());
        supplier.setImporter(editSupplierModel.getImporter());
        supplier.setName(editSupplierModel.getName());
        this.partSupplierRepository.saveAndFlush(supplier);
    }

    @Override
    public void delete(EditPartSupplierModel editSupplierModel) {
        PartSupplier supplier = this.partSupplierRepository.findOne(editSupplierModel.getId());
        this.partSupplierRepository.delete(supplier);
    }
}
