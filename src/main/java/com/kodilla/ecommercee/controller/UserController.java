package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.dto.UserDto;
import com.kodilla.ecommercee.exception.KeyException;
import com.kodilla.ecommercee.exception.UserConflictException;
import com.kodilla.ecommercee.exception.UserNotFoundException;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.service.UserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private UserDbService service;

    @Autowired
    private UserMapper userMapper;

    @PostMapping( value = "createUser")
    public void createUser(@RequestBody UserDto userDto) throws UserConflictException {
        service.addNewUser(userMapper.mapUserDtoToUser(userDto));
    }

    @PutMapping( value = "blockUser")
    public UserDto blockUser(@RequestParam Long userId) throws UserNotFoundException {
        return userMapper.mapUserToUserDto(service.blockUser(userId));
    }

    @PutMapping( value = "createUserKey")
    public String createUserKey(@RequestParam String username, @RequestParam String password) throws UserNotFoundException, KeyException {
        return service.createKeyForUser(username, password);
    }
}
