package com.kodilla.ecommercee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CartDto {

    private long cartId;
    private long userId;
    private List<ProductDto> productDtoList = new ArrayList<>();
}
