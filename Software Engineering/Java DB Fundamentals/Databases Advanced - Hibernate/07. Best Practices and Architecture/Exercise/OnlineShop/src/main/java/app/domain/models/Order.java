package app.domain.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGINT UNSIGNED")
    private long id;

    @Basic
    private Date orderDate;

    @OneToMany(mappedBy = "order", targetEntity = LineItem.class, cascade = CascadeType.ALL)
    private Set<LineItem> lineItems;

    @Transient
    private Location location;

    public Order() {
        super();
    }

    public Order(Date orderDate, Location location) {
        this.setOrderDate(orderDate);
        this.setLocation(location);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Set<LineItem> getLineItems() {
        if (this.lineItems == null) {
            this.setLineItems(new HashSet<>());
        }

        return lineItems;
    }

    public void setLineItems(Set<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void addLineItem(LineItem lineItem) {
        this.getLineItems().add(lineItem);
    }

    public void removeLineItem(LineItem lineItem) {
        this.getLineItems().remove(lineItem);
    }
}
