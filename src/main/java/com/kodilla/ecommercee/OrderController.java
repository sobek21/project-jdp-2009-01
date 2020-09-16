package com.kodilla.ecommercee;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1")
public class OrderController {

    @RequestMapping(method = RequestMethod.GET, value = "getOrders")
    public List<Object> getOrders() {
        return new ArrayList<>();
    }

    @RequestMapping(method = RequestMethod.GET, value = "getOrder")
    public Object getOrder(@RequestParam Long orderId){
        return new Object();
    }

    @RequestMapping(method = RequestMethod.POST, value = "addNewOrder")
    public void addNewOrder(@RequestBody Object o) {}

    @RequestMapping(method = RequestMethod.PUT, value = "updateOrder")
    public Object updateOrder(@RequestBody Object o) {
        return new Object();
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "deleteOrder")
    public void deleteOrder(@RequestParam Long orderId) {}
}
