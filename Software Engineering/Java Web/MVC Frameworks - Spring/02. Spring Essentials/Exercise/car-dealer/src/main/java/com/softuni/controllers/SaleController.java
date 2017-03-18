package com.softuni.controllers;

import com.softuni.models.viewModels.sale.SaleView;
import com.softuni.services.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

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
}
