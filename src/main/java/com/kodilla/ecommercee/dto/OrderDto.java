package com.kodilla.ecommercee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class OrderDto {
    private Long orderId;
    private UserDto user;
    private List<ProductDto> products;
}
