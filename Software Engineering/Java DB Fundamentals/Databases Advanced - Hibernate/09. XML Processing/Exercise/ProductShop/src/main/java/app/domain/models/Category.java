package app.domain.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT UNSIGNED")
    private long id;

    @Basic(optional = false)
    private String name;

    @ManyToMany(mappedBy = "categories", targetEntity = Product.class)
    private Set<Product> products;

    public Category() {
        super();
    }

    public Category(String name) {
        this.setName(name);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.length() < 3 || name.length() > 15) {
            throw new IllegalArgumentException("Name must be between 3 and 15 characters long.");
        }
        this.name = name;
    }

    public Set<Product> getProducts() {
        if (this.products == null) {
            this.setProducts(new HashSet<>());
        }
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
