package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.Cart;
import com.kodilla.ecommercee.domain.Order;
import com.kodilla.ecommercee.dto.CartDto;
import com.kodilla.ecommercee.dto.OrderDto;
import com.kodilla.ecommercee.dto.UserDto;
import com.kodilla.ecommercee.exception.order.CartNotFoundException;
import com.kodilla.ecommercee.exception.product.ProductNotFoundException;
import com.kodilla.ecommercee.exception.user.UserNotFoundException;
import com.kodilla.ecommercee.mapper.CartMapper;
import com.kodilla.ecommercee.service.CartDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1")
public class CartController {

    @Autowired
    private CartMapper cartMapper;

    @Autowired
    private CartDbService cartDbService;


    @PostMapping("/createCart")
    public Cart createCart(@RequestBody CartDto cartDto) {
        return cartDbService.createCart(cartMapper.cartDtoToCart(cartDto));
    }

    @GetMapping("/getCart/{cartId}")
    public CartDto getCart(@PathVariable Long cartId) throws CartNotFoundException {
        return cartMapper.cartToCartDto(cartDbService.getCartById(cartId));
    }

    @PostMapping("/addProduct/{cartId}/{productId}")
    public Cart addProduct(@PathVariable Long cartId, @PathVariable Long productId) throws CartNotFoundException, ProductNotFoundException {
        return cartDbService.addProductToCart(cartId, productId);
    }

    @DeleteMapping("/deleteProduct/{cartId}/{productId}")
    public Cart deleteProduct(@PathVariable Long cartId, @PathVariable Long productId) throws CartNotFoundException, ProductNotFoundException {
        return cartDbService.deleteProductFromCart(cartId, productId);
    }

    @PostMapping("/createOrder/{cartId}/{userId}")
    public Order createOrder(@PathVariable Long cartId, @PathVariable Long userId) throws CartNotFoundException, UserNotFoundException {
        return cartDbService.createOrder(cartId, userId);
    }
}

