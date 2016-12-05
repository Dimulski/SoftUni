package com.onlineshop.domain.model;

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
    private long id;

    @Column(name = "order_date")
    private Date orderDate;

    @OneToMany(mappedBy = "order", targetEntity = LineItem.class, cascade = CascadeType.ALL)
    private Set<LineItem> lineItems;

    @Transient
    private Location location;

    public Order() {
        this.setLineItems(new HashSet<>());
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getOrderDate() {
        return this.orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Set<LineItem> getLineItems() {
        return this.lineItems;
    }

    public void setLineItems(Set<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    public Location getLocation() {
        return this.location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public void addLineItem(LineItem lineItem){
        this.getLineItems().add(lineItem);
    }

    public void deleteLineItem(LineItem lineItem){
        this.getLineItems().remove(lineItem);
    }
}
