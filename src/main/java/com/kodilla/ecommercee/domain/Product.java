package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "PRODUCT")
public class Product {
    @Id
    @Column(name = "PRODUCT_ID")
    private Long productId;
    @Column(name = "NAME")
    private String productName;
    @Column(name = "PRICE")
    private double productPrice;
    @Column(name = "QUANTITY")
    private int quantity;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "products")
    private List<Order> orders;
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "products")
    private List<Cart> carts = new ArrayList<>();
