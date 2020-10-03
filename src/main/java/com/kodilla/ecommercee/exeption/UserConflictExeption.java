package com.kodilla.ecommercee.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class UserConflictExeption extends Exception {
    public UserConflictExeption(String message) {
        super(message);
    }
}
