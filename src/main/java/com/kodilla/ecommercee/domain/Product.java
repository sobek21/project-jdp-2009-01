package com.kodilla.ecommercee.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@NoArgsConstructor
@Getter
@Entity(name = "PRODUCT")
public class Product {
    private Long productId;
    private String productName;
    private double productPrice;
    private int quantity;
    private List<Order> orders;

    public Product(Long productId, String productName, double productPrice, int quantity) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
        this.quantity = quantity;
    }

    @Column(name = "NAME")
    public String getProductName() {
        return productName;
    }

    @Column(name = "PRICE")
    public double getProductPrice() {
        return productPrice;
    }

    @Column(name = "QUANTITY")
    public int getQuantity() {
        return quantity;
    }

    @Id
    @NotNull
    @GeneratedValue
    @Column(name = "PRODUCT_ID")
    public Long getProductId() {
        return productId;
    }

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "products")
    public List<Order> getOrders() {
        return orders;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductPrice(double productPrice) {
        this.productPrice = productPrice;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
