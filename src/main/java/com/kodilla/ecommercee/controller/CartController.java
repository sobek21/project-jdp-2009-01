package com.kodilla.ecommercee.controller;



import com.kodilla.ecommercee.dto.CartDto;
import com.kodilla.ecommercee.dto.OrderDto;
import com.kodilla.ecommercee.dto.ProductDto;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1")
public class CartController {




    @PostMapping("/createCart")
    public CartDto createCard(@RequestBody CartDto cartDto) {
        return new CartDto();
    }

    @GetMapping("/getCart/{cartId}")
    public CartDto getCart(@PathVariable Long cartId) {
        return new CartDto();
    }

    @PutMapping("/addProduct")
    public boolean addProduct(@RequestBody ProductDto productDto) {
        return new CartDto().getProductDtoList().add(productDto);
    }

    @DeleteMapping("/deleteProduct/{productId}")
    public boolean deleteProduct(@PathVariable Long productId) {
        return new CartDto().getProductDtoList().remove(productId);
    }

    @PostMapping("/createOrder")
    public OrderDto createOrder(@RequestBody OrderDto orderDto) {
        return new OrderDto(1,"Name");
    }
}
