package com.softuni.controllers;

import com.softuni.entities.enums.Operation;
import com.softuni.models.bindingModels.car.RelatedCarModel;
import com.softuni.models.bindingModels.customer.RelatedCustomerModel;
import com.softuni.models.bindingModels.log.LogModel;
import com.softuni.models.bindingModels.sale.SaleModel;
import com.softuni.models.bindingModels.user.LoggedUser;
import com.softuni.models.viewModels.car.CarView;
import com.softuni.models.viewModels.car.CarWithPartsView;
import com.softuni.models.viewModels.customer.CustomerDriverView;
import com.softuni.models.viewModels.customer.CustomerNameView;
import com.softuni.models.viewModels.sale.FinalizeSaleView;
import com.softuni.models.viewModels.sale.SaleView;
import com.softuni.services.CarService;
import com.softuni.services.CustomerService;
import com.softuni.services.LogService;
import com.softuni.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("sales")
public class SaleController {

    @Autowired
    private SaleService saleService;
    
    @Autowired
    private CarService carService;
    
    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private LogService logService;

    @GetMapping("")
    private String getAllSales(Model model) {
        List<SaleView> saleViews = this.saleService.getAll();
        model.addAttribute("sales", saleViews);
        model.addAttribute("view", "/sales/sales-table");

        return "base-layout";
    }

    @GetMapping("{id}")
    private String getSaleDetails(Model model, @PathVariable Long id) {
        SaleView saleView = this.saleService.getById(id);
        model.addAttribute("sale", saleView);
        model.addAttribute("view", "/sales/sale-details");

        return "base-layout";
    }

    @GetMapping("discounted")
    private String getDiscountedSales(Model model, @RequestParam(required = false) String discount) {
        List<SaleView> saleViews = this.saleService.getDiscounted(discount);
        model.addAttribute("sales", saleViews);
        model.addAttribute("view", "/sales/sales-table");

        return "base-layout";
    }
    
    @GetMapping("add")
    private String getAddSalePage(Model model) {
        List<CarView> cars = this.carService.getAll();
        List<CustomerNameView> customers = this.customerService.getAll();
        
        model.addAttribute("cars", cars);
        model.addAttribute("customers", customers);
        model.addAttribute("sale", new SaleModel());
        model.addAttribute("view", "sales/sales-add");
        
        return "base-layout";
    }
    
    @PostMapping("add")
    private String addSale(@ModelAttribute SaleModel saleModel,
                           @RequestParam String customerName,
                           @RequestParam String carName,
                           RedirectAttributes redirectAttributes) {
        RelatedCarModel relatedCarModel = this.carService.getByMake(carName);
        RelatedCustomerModel relatedCustomerModel = this.customerService.getByName(customerName);
        saleModel.setCar(relatedCarModel);
        saleModel.setCustomer(relatedCustomerModel);
        redirectAttributes.addFlashAttribute("sale", saleModel);
        
        return "redirect:/sales/add/finalize";
    }

    @GetMapping("add/finalize")
    public String getFinalizeSalePage(Model model) {
        SaleModel saleModel = (SaleModel) model.asMap().get("sale");
        CarWithPartsView carWithPartsView = this.carService.getById(saleModel.getCar().getId());
        CustomerDriverView customerDriverView = this.customerService.getDriverById(saleModel.getCustomer().getId());

        final double[] carPrice = {0};
        carWithPartsView.getParts().stream().forEach(car -> carPrice[0] += car.getPrice());
        double totalPrice = carPrice[0] * (1 - (saleModel.getDiscount() + (customerDriverView.getIsYoungDriver() ? 0.05 : 0)));

        FinalizeSaleView finalizeSaleView = new FinalizeSaleView();
        finalizeSaleView.setDiscount(saleModel.getDiscount());
        finalizeSaleView.setCar(carWithPartsView);
        finalizeSaleView.setCustomer(customerDriverView);
        finalizeSaleView.setCarPrice(carPrice[0]);
        finalizeSaleView.setFinalCarPrice(totalPrice);

        model.addAttribute("sale", finalizeSaleView);
        model.addAttribute("view", "sales/sale-finalize");
        
        return "base-layout";
    }

    @PostMapping("add/finalize")
    public String finalizeSale(@ModelAttribute SaleModel saleModel,
                               @RequestParam String customerName,
                               @RequestParam String carName,
                               HttpSession httpSession) {
        RelatedCarModel relatedCarModel = this.carService.getByMake(carName);
        RelatedCustomerModel relatedCustomerModel = this.customerService.getByName(customerName);

        saleModel.setCar(relatedCarModel);
        saleModel.setCustomer(relatedCustomerModel);
        this.saleService.persist(saleModel);

        LoggedUser loggedUser = (LoggedUser) httpSession.getAttribute("user");
        LogModel logModel = new LogModel(loggedUser, "Sales", Operation.ADD, new Date());
        this.logService.persist(logModel);
        
        return "redirect:/sales";
    }
}
