package com.softuni.controllers;

import com.softuni.models.viewModels.customer.CustomerDetailsView;
import com.softuni.models.viewModels.customer.CustomerView;
import com.softuni.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("all")
    public String getAllCustomers(Model model, @RequestParam(value = "filter",required = false) String filter) {
        List<CustomerView> customerViews = this.customerService.getAllOrderByBirthDate(filter);
        model.addAttribute("customers", customerViews);
        model.addAttribute("view", "/customers/customers-table");

        return "base-layout";
    }

    @GetMapping("{id}")
    public String getCustomerDetails(Model model, @PathVariable Long id) {
        CustomerDetailsView customerDetailsView = this.customerService.getById(id);
        model.addAttribute("customer",customerDetailsView);
        model.addAttribute("view","/customers/customer-details");

        return "base-layout";
    }
}
