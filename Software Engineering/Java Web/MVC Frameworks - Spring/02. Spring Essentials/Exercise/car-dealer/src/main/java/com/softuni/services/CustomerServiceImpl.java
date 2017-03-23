package com.softuni.services;

import com.softuni.entities.Customer;
import com.softuni.models.bindingModels.customer.AddCustomerModel;
import com.softuni.models.bindingModels.customer.EditCustomerModel;
import com.softuni.models.bindingModels.customer.RelatedCustomerModel;
import com.softuni.models.viewModels.customer.CustomerDetailsView;
import com.softuni.models.viewModels.customer.CustomerDriverView;
import com.softuni.models.viewModels.customer.CustomerNameView;
import com.softuni.models.viewModels.customer.CustomerView;
import com.softuni.repositories.CustomerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public List<CustomerView> getAllOrderByBirthDate(String type) {
        List<Customer> customers = new ArrayList<>();
        if ("Descending".equals(type)) {
            customers = this.customerRepository.findAllOrderByBirthDateDescIsYoungDriverAsc();
        } else {
            customers = this.customerRepository.findAllOrderByBirthDateAscIsYoungDriverAsc();
        }

        ModelMapper modelMapper = new ModelMapper();
        List<CustomerView> customerViews = new ArrayList<>();

        for (Customer customer : customers) {
            CustomerView customerView = modelMapper.map(customer, CustomerView.class);
            customerViews.add(customerView);
        }

        return customerViews;
    }

    @Override
    public CustomerDetailsView getById(Long id) {
        Customer customer = this.customerRepository.findOne(id);
        ModelMapper modelMapper = new ModelMapper();
        CustomerDetailsView customerDetailsView = null;
        if (customer != null) {
            customerDetailsView = modelMapper.map(customer, CustomerDetailsView.class);
            final Double[] totalSum = {0D};
            CustomerDetailsView finalCustomerDetailsView = customerDetailsView;
            customer.getSales().forEach(sale -> {
                final double[] sum = {0};
                sale.getCar().getParts().stream().forEach(part -> {
                    sum[0] += part.getPrice();
                });

                totalSum[0] += sum[0] * (1 - (sale.getDiscount() + (finalCustomerDetailsView.getIsYoungDriver() ? 0.05 : 0)));
            });
            customerDetailsView.setTotalSum(totalSum[0]);
        }

        return customerDetailsView;
    }

    @Override
    public void persist(AddCustomerModel addCustomerModel) {
        ModelMapper modelMapper = new ModelMapper();
        Customer customer = modelMapper.map(addCustomerModel, Customer.class);
        this.customerRepository.saveAndFlush(customer);
    }

    @Override
    public EditCustomerModel getEditModelById(Long id) {
        Customer customer = this.customerRepository.findOne(id);
        EditCustomerModel editCustomerModel = null;
        if (customer != null) {
            ModelMapper modelMapper = new ModelMapper();
            editCustomerModel = modelMapper.map(customer, EditCustomerModel.class);
        }

        return editCustomerModel;
    }

    @Override
    public void update(EditCustomerModel customerModel) {
        ModelMapper modelMapper = new ModelMapper();
        Customer customer = modelMapper.map(customerModel, Customer.class);
        this.customerRepository.saveAndFlush(customer);
    }

    @Override
    public List<CustomerNameView> getAll() {
        List<CustomerNameView> customerViews = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        List<Customer> customers = this.customerRepository.findAll();
        for (Customer customer : customers) {
            CustomerNameView customerNameView = modelMapper.map(customer, CustomerNameView.class);
            customerViews.add(customerNameView);
        }

        return customerViews;
    }

    @Override
    public RelatedCustomerModel getByName(String name) {
        RelatedCustomerModel relatedCustomerModel = null;
        Customer customer = this.customerRepository.findFirstByName(name);
        if (customer != null) {
            ModelMapper modelMapper = new ModelMapper();
            relatedCustomerModel = modelMapper.map(customer, RelatedCustomerModel.class);

        }
        
        return relatedCustomerModel;
    }

    @Override
    public CustomerDriverView getDriverById(Long id) {
        CustomerDriverView customerDriverView = null;
        Customer customer = this.customerRepository.findOne(id);
        if (customer != null) {
            ModelMapper modelMapper = new ModelMapper();
            customerDriverView = modelMapper.map(customer, CustomerDriverView.class);
        }
        
        return customerDriverView;
    }
}
