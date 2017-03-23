package com.softuni.controllers;

import com.softuni.entities.enums.Operation;
import com.softuni.models.bindingModels.log.LogModel;
import com.softuni.models.bindingModels.partSupplier.AddPartSupplierModel;
import com.softuni.models.bindingModels.partSupplier.EditPartSupplierModel;
import com.softuni.models.bindingModels.user.LoggedUser;
import com.softuni.models.viewModels.partSupplier.PartSupplierView;
import com.softuni.services.LogService;
import com.softuni.services.PartSupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/part-suppliers")
public class PartSupplierController {

    @Autowired
    private PartSupplierService partSupplierService;
    
    @Autowired
    private LogService logService;

    @GetMapping("")
    public String getFilteredPartSuppliers(Model model, @RequestParam(value = "type",required = false) String type) {
        Boolean isImporter = "Importers".equals(type);
        List<PartSupplierView> partSupplierViews = this.partSupplierService.getFilteredPartSuppliers(isImporter);
        model.addAttribute("partSuppliers", partSupplierViews);
        model.addAttribute("view", "/partSuppliers/part-suppliers-table");

        return "base-layout";
    }

    @GetMapping("add")
    public String getAddSupplierPage(Model model){
        model.addAttribute("view", "/partSuppliers/part-supplier-modifiable");
        model.addAttribute("partSupplier", new AddPartSupplierModel());
        model.addAttribute("type", "Add");
        
        return "base-layout";
    }

    @PostMapping("add")
    public String  addSupplier(@ModelAttribute AddPartSupplierModel supplierModel, HttpSession httpSession){
        this.partSupplierService.persist(supplierModel);
        LoggedUser loggedUser = (LoggedUser) httpSession.getAttribute("user");
        LogModel logModel = new LogModel(loggedUser,"Suppliers", Operation.ADD,new Date());
        this.logService.persist(logModel);
        
        return "redirect:/part-suppliers";
    }

    @GetMapping("edit/{id}")
    public String getEditPage(Model model,@PathVariable Long id){
        EditPartSupplierModel editPartSupplierModel = this.partSupplierService.getByIdToEdit(id);
        model.addAttribute("view", "/partSuppliers/part-supplier-modifiable");
        model.addAttribute("type", "Edit");
        model.addAttribute("partSupplier", editPartSupplierModel);
        
        return "base-layout";
    }

    @PostMapping("edit/{id}")
    public String editSupplier(@ModelAttribute EditPartSupplierModel editSupplierModel,@PathVariable Long id,HttpSession httpSession){
        editSupplierModel.setId(id);
        this.partSupplierService.update(editSupplierModel);
        LoggedUser loggedUser = (LoggedUser) httpSession.getAttribute("user");
        LogModel logModel = new LogModel(loggedUser,"Suppliers", Operation.EDIT,new Date());
        this.logService.persist(logModel);
        
        return "redirect:/part-suppliers";
    }

    @GetMapping("delete/{id}")
    public String getDeletePage(Model model,@PathVariable Long id){
        EditPartSupplierModel editSupplierModel = this.partSupplierService.getByIdToEdit(id);
        model.addAttribute("view", "/partSuppliers/part-supplier-modifiable");
        model.addAttribute("type", "Delete");
        model.addAttribute("partSupplier" ,editSupplierModel);
        
        return "base-layout";
    }

    @PostMapping("delete/{id}")
    public String deleteSupplier(@ModelAttribute EditPartSupplierModel editSupplierModel,@PathVariable Long id,HttpSession httpSession){
        editSupplierModel.setId(id);
        this.partSupplierService.delete(editSupplierModel);
        LoggedUser loggedUser = (LoggedUser) httpSession.getAttribute("user");
        LogModel logModel = new LogModel(loggedUser, "Suppliers", Operation.DELETE,new Date());
        this.logService.persist(logModel);
        return "redirect:/part-suppliers";
    }
}
