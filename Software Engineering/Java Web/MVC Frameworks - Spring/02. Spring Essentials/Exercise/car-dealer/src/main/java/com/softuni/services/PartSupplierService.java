package com.softuni.services;

import com.softuni.models.bindingModels.partSupplier.PartSupplierModel;
import com.softuni.models.viewModels.partSupplier.PartSupplierView;

import java.util.List;

public interface PartSupplierService {

    List<PartSupplierView> getFilteredPartSuppliers(Boolean isImporter);
    List<PartSupplierView> getAll();
    PartSupplierModel getByName(String name);
}
