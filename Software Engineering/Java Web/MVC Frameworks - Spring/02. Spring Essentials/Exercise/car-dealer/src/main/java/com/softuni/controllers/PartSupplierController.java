package com.softuni.controllers;

import com.softuni.models.viewModels.partSupplier.PartSupplierView;
import com.softuni.services.PartSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/part-suppliers")
public class PartSupplierController {

    @Autowired
    private PartSupplierService partSupplierService;

    @GetMapping("")
    public String getFilteredPartSuppliers(Model model, @RequestParam(value = "type",required = false) String type) {
        Boolean isImporter = "Importers".equals(type);
        List<PartSupplierView> partSupplierViews = this.partSupplierService.getFilteredPartSuppliers(isImporter);
        model.addAttribute("partSuppliers", partSupplierViews);
        model.addAttribute("view", "/partSuppliers/part-suppliers-table");

        return "base-layout";
    }
}
