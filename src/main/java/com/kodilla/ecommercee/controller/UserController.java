package com.kodilla.ecommercee.controller;

import com.kodilla.ecommercee.domain.User;
import com.kodilla.ecommercee.dto.UserDto;
import com.kodilla.ecommercee.exception.user.KeyException;
import com.kodilla.ecommercee.exception.user.UserConflictException;
import com.kodilla.ecommercee.exception.user.UserNotFoundException;
import com.kodilla.ecommercee.mapper.UserMapper;
import com.kodilla.ecommercee.service.UserDbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@EnableScheduling
@RequestMapping("/v1/user")
public class UserController {

    @Autowired
    private UserDbService service;

    @Autowired
    private UserMapper userMapper;


    @PostMapping(value = "createUser")
    public void createUser(@RequestBody UserDto userDto) throws UserConflictException {
        service.addNewUser(userMapper.mapUserDtoToUser(userDto));
    }

    @Scheduled(fixedRate = 60000)
    @PutMapping(value = "blockUsers")
    public List<UserDto> blockUsers() {
        return userMapper.mapToUserDtoList(service.blockUsers());
    }

    @PutMapping(value = "createUserKey")
    public String createUserKey(@RequestParam String username, @RequestParam String password) throws UserNotFoundException, KeyException {
        return service.createKeyForUser(username, password);
    }


}
