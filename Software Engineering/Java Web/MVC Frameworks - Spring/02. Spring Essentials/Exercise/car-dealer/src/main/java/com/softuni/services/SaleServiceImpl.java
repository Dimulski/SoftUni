package com.softuni.services;

import com.softuni.entities.Sale;
import com.softuni.models.bindingModels.sale.SaleModel;
import com.softuni.models.viewModels.sale.SaleView;
import com.softuni.repositories.SaleRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Override
    public List<SaleView> getAll() {
        List<Sale> sales = this.saleRepository.findAll();
        List<SaleView> saleViews = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for (Sale sale : sales) {
            SaleView saleView = modelMapper.map(sale, SaleView.class);
            saleViews.add(saleView);
        }

        return saleViews;
    }

    @Override
    public SaleView getById(Long id) {
        Sale sale = this.saleRepository.findOne(id);
        SaleView saleView = null;
        if (sale != null) {
            ModelMapper modelMapper = new ModelMapper();
            saleView = modelMapper.map(sale, SaleView.class);
        }

        return saleView;
    }

    @Override
    public List<SaleView> getDiscounted(String discount) {
        List<Sale> sales = new ArrayList<>();

        if (discount != null) {
            sales = this.saleRepository.findAllByDiscount(Double.parseDouble(discount));
        } else {
            sales = this.saleRepository.findAllDiscounted();
        }

        List<SaleView> saleViews = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        for (Sale sale : sales) {
            SaleView saleView = modelMapper.map(sale, SaleView.class);
            saleViews.add(saleView);
        }

        return saleViews;
    }

    @Override
    public void persist(SaleModel saleModel) {
        ModelMapper modelMapper = new ModelMapper();
        Sale sale = modelMapper.map(saleModel,Sale.class);
        this.saleRepository.saveAndFlush(sale);
    }
}
