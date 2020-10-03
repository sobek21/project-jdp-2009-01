package com.kodilla.ecommercee.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundExeption extends Exception{
    public UserNotFoundExeption(String message) {
        super(message);
    }
}
