package com.softuni.services;

import com.softuni.entities.PartSupplier;
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
        List<PartSupplier> partSuppliers = this.partSupplierRepository.getAllByIsImporter(isImporter);

        List<PartSupplierView> partSupplierViews = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for (PartSupplier partSupplier : partSuppliers) {
            PartSupplierView partSupplierView = modelMapper.map(partSupplier, PartSupplierView.class);
            partSupplierViews.add(partSupplierView);
        }

        return partSupplierViews;
    }
}
