package com.kodilla.ecommercee;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1")
public class UserController {
    @RequestMapping(method = RequestMethod.POST, value = "createUser")
    public void createUser(@RequestBody Object object) {

    }

    @RequestMapping(method = RequestMethod.PUT, value = "blockUser")
    public Object blockUser(@RequestParam Long userId) {
        return new Object();
    }

    @RequestMapping(method = RequestMethod.POST, value = "createUserKey")
    public long createUserKey(@RequestParam Long userKey) {
        return userKey;
    }
}
