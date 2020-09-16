package com.kodilla.ecommercee;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1")
public class ProductController {
    @RequestMapping(method = RequestMethod.GET, value = "getAllProducts")
    public List<Object> getAllProducts() {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getProduct")
    public Object getProduct(@RequestParam(value = "productId") Long productId) {
        return new Object();
    }

    @RequestMapping(method = RequestMethod.POST, value = "createProduct")
    public void createProduct(@RequestBody Object object) {

    }

    @RequestMapping(method = RequestMethod.PUT, value = "updateProduct")
    public Object updateProduct(@RequestBody Object object) {
        return new Object();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteProduct")
    public void deleteProduct(@RequestBody Object object) {
    }
}
