package com.kodilla.ecommercee.dto;

import lombok.Getter;

@Getter
public class UserDto {
    private long userId;
    private long userKey;
    private String username;
    private String password;

    public UserDto(final String username, final String password) {
        this.username = username;
        this.password = password;
    }
}