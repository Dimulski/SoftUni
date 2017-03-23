package com.softuni.services;

import com.softuni.models.bindingModels.sale.SaleModel;
import com.softuni.models.viewModels.sale.SaleView;

import java.util.List;

public interface SaleService {

    List<SaleView> getAll();
    SaleView getById(Long id);
    List<SaleView> getDiscounted(String discount);
    void persist(SaleModel saleModel);
}
