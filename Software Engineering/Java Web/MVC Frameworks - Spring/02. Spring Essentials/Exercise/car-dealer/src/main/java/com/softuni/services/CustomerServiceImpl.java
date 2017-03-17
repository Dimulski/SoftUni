package com.softuni.services;

import com.softuni.entities.Customer;
import com.softuni.models.viewModels.customer.CustomerDetailsView;
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
            customers = this.customerRepository.getAllOrderByBirthDateDescIsYoungDriverAsc();
        } else {
            customers = this.customerRepository.getAllOrderByBirthDateAscIsYoungDriverAsc();
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
}
