package com.kodilla.ecommercee.domain;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@Entity
@Table(name = "ORDERS")
public class Order {
    private Long orderId;
    private Date created;
    private User user;
    private List<Product> products;

    public Order(Long orderId, User user, List<Product> products) {
        this.orderId = orderId;
        this.user = user;
        this.products = products;
        this.created = new Date();
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ORDER_ID")
    public Long getOrderId() {
        return orderId;
    }

    public Date getCreated() {
        return created;
    }

    @JoinColumn(name = "USER_ASSIGNEDTO_ORDER")
    @ManyToOne
    public User getUser() {
        return user;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "ORDER_PRODUCT",
            joinColumns = {@JoinColumn(name = "ORDER_ID", referencedColumnName = "ORDER_ID")},
            inverseJoinColumns = {@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "PRODUCT_ID")}

    )
    public List<Product> getProducts() {
        return products;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
