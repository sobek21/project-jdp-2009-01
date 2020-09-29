package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.CartDto;
import com.kodilla.ecommercee.dto.OrderDto;
import com.kodilla.ecommercee.dto.ProductDto;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1")
public class CartController {


    @PostMapping("/createCart")
    public CartDto createCart(@RequestBody CartDto cartDto) {
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
    public OrderDto createOrder(@RequestParam(value = "cartId") @NotNull Long cartId) {
        return new OrderDto(1, "Name");
    }
}
