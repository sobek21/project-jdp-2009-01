package com.kodilla.ecommercee.domain;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long productId;

    @Column(name = "NAME", unique = true)
    private String productName;

    @Column(name = "PRICE")
    private double productPrice;

    @Column(name = "QUANTITY")
    private int quantity;
}

