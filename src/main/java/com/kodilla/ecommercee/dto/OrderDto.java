package com.kodilla.ecommercee.dto;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.User;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class OrderDto {
    private Long orderId;
    private User user;
    private List<Product> products;
}
