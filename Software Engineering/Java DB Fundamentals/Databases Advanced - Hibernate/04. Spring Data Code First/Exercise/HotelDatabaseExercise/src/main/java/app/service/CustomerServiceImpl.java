package app.service;

import app.domain.Customer;
import app.repositories.CustomerRepository;
import app.service.contracts.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public void create(Customer customer) {
        this.customerRepository.saveAndFlush(customer);
    }
}
