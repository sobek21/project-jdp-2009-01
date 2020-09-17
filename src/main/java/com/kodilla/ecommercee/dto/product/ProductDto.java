package com.kodilla.ecommercee.dto.product;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProductDto {
    private Long productId;
    private String productName;
    private double productPrice;
    private int quantity;
}
