package com.kodilla.ecommercee.dto;

import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.domain.User;
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

    public CartDto(long cartId, long userId) {
        this.cartId = cartId;
        this.userId = userId;
    }


}
