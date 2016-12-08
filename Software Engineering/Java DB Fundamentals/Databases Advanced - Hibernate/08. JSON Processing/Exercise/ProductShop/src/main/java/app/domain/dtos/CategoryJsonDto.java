package app.domain.dtos;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class CategoryJsonDto implements Serializable {

    @Expose
    private String name;

    public CategoryJsonDto() {
        super();
    }

    public CategoryJsonDto(String name) {
        this.setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
