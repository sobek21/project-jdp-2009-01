package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.UserDto;
import com.kodilla.ecommercee.exeption.UserConflictExeption;
import com.kodilla.ecommercee.exeption.UserNotFoundExeption;
import com.kodilla.ecommercee.service.UserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private UserDbService service;

    @RequestMapping(method = RequestMethod.POST, value = "createUser")
    public void createUser(@RequestParam String username,@RequestParam String password) throws UserConflictExeption {
        service.addNewUser(username,password);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "blockUser")
    public UserDto blockUser(@RequestParam Long userId) throws UserNotFoundExeption {
        return service.blockUser(userId);
    }

    @RequestMapping(method = RequestMethod.POST, value = "createUserKey")
    public void createUserKey(@RequestParam String username,@RequestParam String password) throws UserNotFoundExeption {
        service.createKeyForUser(username,password);
    }
}
