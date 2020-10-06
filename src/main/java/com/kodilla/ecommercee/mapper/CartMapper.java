package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.dto.CartDto;
import org.springframework.stereotype.Component;

@Component
public class CartMapper {

    public CartDto cartToCartDto(Cart cart) {
        return new CartDto();
    }

    public Cart cartDtoToCart(CartDto cartDto) {
        return new Cart();
    }
}
