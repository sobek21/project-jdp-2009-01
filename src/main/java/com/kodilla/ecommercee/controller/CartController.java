package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.dto.CartDto;
import com.kodilla.ecommercee.dto.OrderDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1")
public class CartController {


    @PostMapping("/createCart")
    public CartDto createCard(@RequestBody CartDto cartDto) {
        return new CartDto();
    }

    @GetMapping("/getCart/{cartId}")
    public CartDto getCart(@PathVariable int cartId) {
        return new CartDto(1, 1, new ArrayList<>());
    }

    @PostMapping("/addProduct")
    public CartDto addProduct(@RequestParam Long cartId, @RequestParam Long productId) {
        return new CartDto();
    }

    @DeleteMapping("/deleteProduct/{productId}")
    public void deleteProduct(@PathVariable int productId) {
    }

    @PostMapping("/createOrder")
    public OrderDto createOrder(@RequestBody OrderDto orderDto) {
        return new OrderDto(1L, new User(), new ArrayList<>());
    }
}
