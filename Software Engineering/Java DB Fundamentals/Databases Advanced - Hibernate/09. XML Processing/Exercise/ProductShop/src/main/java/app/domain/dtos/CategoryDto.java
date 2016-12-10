package app.domain.dtos;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class CategoryDto implements Serializable {

    @Expose
    private String name;

    public CategoryDto() {
        super();
    }

    public CategoryDto(String name) {
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
