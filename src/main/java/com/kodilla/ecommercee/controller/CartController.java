package com.kodilla.ecommercee.controller;


import com.kodilla.ecommercee.dto.cart.CartDto;
import com.kodilla.ecommercee.dto.order.OrderDto;
import com.kodilla.ecommercee.dto.product.ProductDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class CartController {


    private CartDto cartDto;

    //utworzenie pustego koszyka
    @PostMapping("/createCart")
    public CartDto createCard(@RequestBody CartDto cartDto) {
        return new CartDto();
    }
    //pobranie elementów z pustego koszyka
    @GetMapping("/getCart")
    public CartDto getCart(Long cartId) {
        return cartDto;
    }
    //dodanie elementów (produktów) do koszyka
    @PutMapping("/addProduct")
    public boolean addProduct(@RequestBody ProductDto productDto) {
        return cartDto.getProductDtoList().add(productDto);
    }
    //usunięcie konkretnego produktu z koszyka
    @DeleteMapping("/deleteProduct/{productId}")
    public boolean deleteProduct(@PathVariable Long productId) {
        return cartDto.getProductDtoList().remove(productId);
    }
    //utworzenieg zamówienia na podstawie koszyka
    @PostMapping("/createOrder")
    public OrderDto createOrder(@RequestBody OrderDto orderDto) {
        return orderDto;
    }
}
