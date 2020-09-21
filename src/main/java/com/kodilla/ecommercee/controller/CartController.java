package com.kodilla.ecommercee.controller;



import com.kodilla.ecommercee.dto.CartDto;
import com.kodilla.ecommercee.dto.OrderDto;
import com.kodilla.ecommercee.dto.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class CartController {


    private CartDto cartDto;


    @PostMapping("/createCart")
    public CartDto createCard(@RequestBody CartDto cartDto) {
        return new CartDto();
    }

    @GetMapping("/getCart/{cartId}")
    public CartDto getCart(@PathVariable Long cartId) {
        return cartDto;
    }

    @PutMapping("/addProduct")
    public boolean addProduct(@RequestBody ProductDto productDto) {
        return cartDto.getProductDtoList().add(productDto);
    }

    @DeleteMapping("/deleteProduct/{productId}")
    public boolean deleteProduct(@PathVariable Long productId) {
        return cartDto.getProductDtoList().remove(productId);
    }

    @PostMapping("/createOrder")
    public OrderDto createOrder(@RequestBody OrderDto orderDto) {
        return orderDto;
    }
}
