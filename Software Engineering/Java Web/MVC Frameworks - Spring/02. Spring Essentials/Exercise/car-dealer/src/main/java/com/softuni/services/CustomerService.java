package com.softuni.services;

import com.softuni.models.bindingModels.customer.AddCustomerModel;
import com.softuni.models.bindingModels.customer.EditCustomerModel;
import com.softuni.models.viewModels.customer.CustomerDetailsView;
import com.softuni.models.viewModels.customer.CustomerView;

import java.util.List;

public interface CustomerService {

    List<CustomerView> getAllOrderByBirthDate(String type);
    CustomerDetailsView getById(Long id);
    void persist(AddCustomerModel addCustomerModel);
    EditCustomerModel getEditModelById(Long id);
    void update(EditCustomerModel customerModel);
}
