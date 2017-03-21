package com.softuni.controllers;

import com.softuni.models.bindingModels.part.AddPartModel;
import com.softuni.models.bindingModels.part.EditPartModel;
import com.softuni.models.bindingModels.partSupplier.PartSupplierModel;
import com.softuni.models.viewModels.part.PartView;
import com.softuni.models.viewModels.partSupplier.PartSupplierView;
import com.softuni.services.PartService;
import com.softuni.services.PartSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("parts")
public class PartController {

    @Autowired
    private PartService partService;

    @Autowired
    private PartSupplierService partSupplierService;

    @GetMapping("all")
    private String getAllCustomers(Model model) {
        List<PartView> parts = this.partService.getAll();
        model.addAttribute("parts", parts);
        model.addAttribute("view", "/parts/parts-table");

        return "base-layout";
    }

    @GetMapping("add")
    private String getAddPartPage(Model model) {
        List<PartSupplierView> supplierViews = this.partSupplierService.getAll();
        model.addAttribute("suppliers", supplierViews);
        model.addAttribute("part", new AddPartModel());
        model.addAttribute("view", "/parts/parts-add");

        return "base-layout";
    }

    @PostMapping("add")
    private String addPart(@ModelAttribute AddPartModel partModel, @RequestParam String supplierName) {
        PartSupplierModel partSupplierModel = this.partSupplierService.getByName(supplierName);
        partModel.setSupplier(partSupplierModel);
        partModel.setQuantity(partModel.getQuantity() == null? 1 : partModel.getQuantity());

        this.partService.persist(partModel);

        return "redirect:/parts/all";
    }

    @GetMapping("edit/{id}")
    private String getEditPart(Model model, @PathVariable Long id) {
        EditPartModel editPartModel = this.partService.getById(id);
        model.addAttribute("part", editPartModel);
        model.addAttribute("view", "parts/parts-edit");

        return "base-layout";
    }

    @PostMapping("edit/{id}")
    private String editPart(@ModelAttribute EditPartModel editPartModel, @PathVariable Long id) {
        editPartModel.setId(id);
        this.partService.update(editPartModel);

        return "redirect:/parts/all";
    }

    @GetMapping("delete/{id}")
    public String getDeletePartPage(Model model,@PathVariable Long id){
        PartView partView = this.partService.getViewById(id);
        model.addAttribute("view", "/parts/parts-delete");
        model.addAttribute("part", partView);

        return "base-layout";
    }

    @PostMapping("delete/{id}")
    public String deletePart(@ModelAttribute EditPartModel editPartModel,@PathVariable Long id){
        editPartModel.setId(id);
        this.partService.delete(editPartModel);

        return "redirect:/parts/all";
    }
}
