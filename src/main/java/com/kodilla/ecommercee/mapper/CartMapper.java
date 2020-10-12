package com.kodilla.ecommercee.mapper;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Product;
import com.kodilla.ecommercee.dto.CartDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CartMapper {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private ProductMapper productMapper;

    public CartDto cartToCartDto(final Cart cart) {
        return new CartDto();
    }

    public Cart cartDtoToCart(final CartDto cartDto) {
        return new Cart();

    }
}
