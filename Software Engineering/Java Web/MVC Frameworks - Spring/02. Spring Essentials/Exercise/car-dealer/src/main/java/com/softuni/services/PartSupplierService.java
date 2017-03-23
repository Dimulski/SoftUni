package com.softuni.services;

import com.softuni.models.bindingModels.partSupplier.AddPartSupplierModel;
import com.softuni.models.bindingModels.partSupplier.EditPartSupplierModel;
import com.softuni.models.bindingModels.partSupplier.PartSupplierModel;
import com.softuni.models.viewModels.partSupplier.PartSupplierView;

import java.util.List;

public interface PartSupplierService {

    List<PartSupplierView> getFilteredPartSuppliers(Boolean isImporter);
    List<PartSupplierView> getAll();
    PartSupplierModel getByName(String name);
    void persist(AddPartSupplierModel supplierModel);
    EditPartSupplierModel getByIdToEdit(Long id);
    void update(EditPartSupplierModel editSupplierModel);
    void delete(EditPartSupplierModel editSupplierModel);
}
