package com.kodilla.ecommercee.domain;

import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Entity(name = "PRODUCTS")
public class Product {
    private Order order;
    private Long productId;
    private String productName;
    private double productPrice;
    private int quantity;

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRODUCT_ID")
    public Long getProductId() {
        return productId;
    }

    @ManyToOne
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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
}
