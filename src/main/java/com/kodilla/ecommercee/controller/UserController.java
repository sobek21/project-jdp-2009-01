package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.UserDto;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/user")
public class UserController {
    @RequestMapping(method = RequestMethod.POST, value = "createUser")
    public void createUser(@RequestBody UserDto userDto) {

    }

    @RequestMapping(method = RequestMethod.PUT, value = "blockUser")
    public Object blockUser(@RequestParam Long userId) {
        return new UserDto(1L, "blockedusername", "blockedfirstname", "blockedlastname");
    }

    @RequestMapping(method = RequestMethod.POST, value = "createUserKey")
    public long createUserKey(@RequestParam Long userKey) {
        return userKey;
    }
}
