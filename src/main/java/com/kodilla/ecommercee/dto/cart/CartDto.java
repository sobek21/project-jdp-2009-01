package com.kodilla.ecommercee.dto.cart;

import com.kodilla.ecommercee.dto.product.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class CartDto {

    private Long cartId;
    private Long userId;
    private List<ProductDto> productDtoList;
}
