package com.softuni.models.bindingModels.partSupplier;

public class AddPartSupplierModel {

    private String name;
    private Boolean isImporter;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getImporter() {
        return isImporter;
    }

    public void setImporter(Boolean importer) {
        isImporter = importer;
    }
}
