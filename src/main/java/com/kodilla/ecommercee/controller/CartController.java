package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.CartDto;
import com.kodilla.ecommercee.dto.OrderDto;
import com.kodilla.ecommercee.dto.ProductDto;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1")
public class CartController {


    @PostMapping("/createCart")
    public CartDto createCard(@RequestBody CartDto cartDto) {
        return new CartDto();
    }

    @GetMapping("/getCart/{cartId}")
    public ProductDto getCart(@PathVariable int cartId) {
        List<ProductDto> productDtoList = new ArrayList<ProductDto>();
        productDtoList.add(new ProductDto((long) 0, "Test", 27, 1));
        return productDtoList.get(cartId);
    }

    @PostMapping("/addProduct")
    public boolean addProduct(@RequestBody ProductDto productDto) {
        List<ProductDto> productDtoList = new ArrayList<ProductDto>();
        return productDtoList.add(productDto);
    }

    @DeleteMapping("/deleteProduct/{productId}")
    public ProductDto deleteProduct(@PathVariable int productId) {
        List<ProductDto> productDtoList = new ArrayList<ProductDto>();
        productDtoList.add(new ProductDto((long) 0, "Test", 27, 1));
        return productDtoList.remove(productId);
    }

    @PostMapping("/createOrder")
    public OrderDto createOrder(@RequestBody OrderDto orderDto) {
        return new OrderDto(1, "Name");
    }
}
